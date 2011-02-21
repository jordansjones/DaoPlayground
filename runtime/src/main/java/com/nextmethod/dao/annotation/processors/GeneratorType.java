package com.nextmethod.dao.annotation.processors;

enum GeneratorType
{
	CONTEXT_INTERFACE ("context", "Context"),
	CONTEXT_IMPL ("context", "ContextImpl");

	private String packagePart;
	private String classSuffix;

	GeneratorType (final String packagePart, final String classSuffix)
	{
		this.packagePart = packagePart;
		this.classSuffix = classSuffix;
	}

	public String getPackagePart ()
	{
		return packagePart;
	}

	public String getClassSuffix ()
	{
		return classSuffix;
	}
}
