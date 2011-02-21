package com.nextmethod.dao.expressions;

public enum ExpressionType
{
	// Base Expressions
	Constant,

	// Composite Expressions
	And,
	Or,

	// Date Expressions
	After,
	Before,
	Between,

	// Equality Expressions
	Equal,
	NotEqual,

	// Nullable Expressions
	Empty,
	NotEmpty,

	// Numeric Expressions
	Greater,
	GreaterOrEqual,
	Less,
	LessOrEqual,
	InRange,

	// Range Expressions
	In,

	// String Expressions
	Begins,
	Contains,
	Ends
}
