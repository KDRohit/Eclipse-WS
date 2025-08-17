package com.ig.sbeans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

// @Data = @Getter + @Setter + @EqualsAndHashCode + @RequiredArgsConstructor
@Data
public class Customer 
{
	private int id;
	private String name;
	private int orderAmount;
}
