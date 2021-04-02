package com.yangxi.cloud.rocketmq.message;

import com.yangxi.cloud.framework.web.constant.TenantContextConstant;
import com.yangxi.cloud.framework.web.context.TenantContext;
import org.springframework.lang.Nullable;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.util.Assert;

import java.util.Map;

public final class MQMessageBuilder<T> {

	private final T payload;

	@Nullable
	private final Message<T> providedMessage;

	private MessageHeaderAccessor headerAccessor;


	private MQMessageBuilder(Message<T> providedMessage) {
		Assert.notNull(providedMessage, "Message must not be null");
		this.payload = providedMessage.getPayload();
		this.providedMessage = providedMessage;
		this.headerAccessor = new MessageHeaderAccessor(providedMessage);
	}

	private MQMessageBuilder(T payload, MessageHeaderAccessor accessor) {
		Assert.notNull(payload, "Payload must not be null");
		Assert.notNull(accessor, "MessageHeaderAccessor must not be null");
		this.payload = payload;
		this.providedMessage = null;
		this.headerAccessor = accessor;
	}


	/**
	 * Set the message headers to use by providing a {@code MessageHeaderAccessor}.
	 * @param accessor the headers to use
	 */
	public MQMessageBuilder<T> setHeaders(MessageHeaderAccessor accessor) {
		Assert.notNull(accessor, "MessageHeaderAccessor must not be null");
		this.headerAccessor = accessor;
		return this;
	}

	/**
	 * Set the value for the given header name. If the provided value is {@code null},
	 * the header will be removed.
	 */
	public MQMessageBuilder<T> setHeader(String headerName, @Nullable Object headerValue) {
		this.headerAccessor.setHeader(headerName, headerValue);
		return this;
	}

	/**
	 * Set the value for the given header name only if the header name is not already
	 * associated with a value.
	 */
	public MQMessageBuilder<T> setHeaderIfAbsent(String headerName, Object headerValue) {
		this.headerAccessor.setHeaderIfAbsent(headerName, headerValue);
		return this;
	}

	/**
	 * Removes all headers provided via array of 'headerPatterns'. As the name suggests
	 * the array may contain simple matching patterns for header names. Supported pattern
	 * styles are: "xxx*", "*xxx", "*xxx*" and "xxx*yyy".
	 */
	public MQMessageBuilder<T> removeHeaders(String... headerPatterns) {
		this.headerAccessor.removeHeaders(headerPatterns);
		return this;
	}

	/**
	 * Remove the value for the given header name.
	 */
	public MQMessageBuilder<T> removeHeader(String headerName) {
		this.headerAccessor.removeHeader(headerName);
		return this;
	}

	/**
	 * Copy the name-value pairs from the provided Map. This operation will overwrite any
	 * existing values. Use { {@link #copyHeadersIfAbsent(Map)} to avoid overwriting
	 * values. Note that the 'id' and 'timestamp' header values will never be overwritten.
	 */
	public MQMessageBuilder<T> copyHeaders(@Nullable Map<String, ?> headersToCopy) {
		this.headerAccessor.copyHeaders(headersToCopy);
		return this;
	}

	/**
	 * Copy the name-value pairs from the provided Map. This operation will <em>not</em>
	 * overwrite any existing values.
	 */
	public MQMessageBuilder<T> copyHeadersIfAbsent(@Nullable Map<String, ?> headersToCopy) {
		this.headerAccessor.copyHeadersIfAbsent(headersToCopy);
		return this;
	}

	public MQMessageBuilder<T> setReplyChannel(MessageChannel replyChannel) {
		this.headerAccessor.setReplyChannel(replyChannel);
		return this;
	}

	public MQMessageBuilder<T> setReplyChannelName(String replyChannelName) {
		this.headerAccessor.setReplyChannelName(replyChannelName);
		return this;
	}

	public MQMessageBuilder<T> setErrorChannel(MessageChannel errorChannel) {
		this.headerAccessor.setErrorChannel(errorChannel);
		return this;
	}

	public MQMessageBuilder<T> setErrorChannelName(String errorChannelName) {
		this.headerAccessor.setErrorChannelName(errorChannelName);
		return this;
	}

	@SuppressWarnings("unchecked")
	public Message<T> build() {

		// 添加统一的header信息
		setHeaderIfAbsent(TenantContextConstant.TENANT_ID, TenantContext.getTenantId());

		if (this.providedMessage != null && !this.headerAccessor.isModified()) {
			return this.providedMessage;
		}
		MessageHeaders headersToUse = this.headerAccessor.toMessageHeaders();

		if (this.payload instanceof Throwable) {
			if (this.providedMessage != null && this.providedMessage instanceof ErrorMessage) {
				Message<?> message = ((ErrorMessage) this.providedMessage).getOriginalMessage();
				if (message != null) {
					return (Message<T>) new ErrorMessage((Throwable) this.payload, headersToUse, message);
				}
			}
			return (Message<T>) new ErrorMessage((Throwable) this.payload, headersToUse);
		}
		else {
			return new GenericMessage<>(this.payload, headersToUse);
		}
	}


	/**
	 * Create a builder for a new {@link Message} instance pre-populated with all of the
	 * headers copied from the provided message. The payload of the provided Message will
	 * also be used as the payload for the new message.
	 * <p>If the provided message is an {@link ErrorMessage}, the
	 * {@link ErrorMessage#getOriginalMessage() originalMessage} it contains, will be
	 * passed on to new instance.
	 * @param message the Message from which the payload and all headers will be copied
	 */
	public static <T> MQMessageBuilder<T> fromMessage(Message<T> message) {
		return new MQMessageBuilder<>(message);
	}

	/**
	 * Create a new builder for a message with the given payload.
	 * @param payload the payload
	 */
	public static <T> MQMessageBuilder<T> withPayload(T payload) {
		return new MQMessageBuilder<>(payload, new MessageHeaderAccessor());
	}

	/**
	 * A shortcut factory method for creating a message with the given payload
	 * and {@code MessageHeaders}.
	 * <p><strong>Note:</strong> the given {@code MessageHeaders} instance is used
	 * directly in the new message, i.e. it is not copied.
	 * @param payload the payload to use (never {@code null})
	 * @param messageHeaders the headers to use (never {@code null})
	 * @return the created message
	 * @since 4.1
	 */
	@SuppressWarnings("unchecked")
	public static <T> Message<T> createMessage(@Nullable T payload, MessageHeaders messageHeaders) {
		Assert.notNull(payload, "Payload must not be null");
		Assert.notNull(messageHeaders, "MessageHeaders must not be null");

		if (payload instanceof Throwable) {
			return (Message<T>) new ErrorMessage((Throwable) payload, messageHeaders);
		}
		else {
			return new GenericMessage<>(payload, messageHeaders);
		}
	}

}