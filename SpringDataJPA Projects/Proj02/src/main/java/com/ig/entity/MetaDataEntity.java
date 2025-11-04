package com.ig.entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;

@MappedSuperclass
public class MetaDataEntity 
{
	@Version
	private Long version;
}
