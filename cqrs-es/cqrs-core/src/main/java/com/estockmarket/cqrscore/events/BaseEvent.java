package com.estockmarket.cqrscore.events;

import com.estockmarket.cqrscore.messages.Message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseEvent extends Message {

	private int version;

}
