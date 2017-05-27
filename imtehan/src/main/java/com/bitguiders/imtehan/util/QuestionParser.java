package com.bitguiders.imtehan.util;

public final class QuestionParser {
	public static final String COMMA_SEPARATOR = "cs~"; 
	public static final String OPTION_SEPARATOR = "os~"; 
	public static final String OPTION_ANSWER_SEPARATOR = "oas~"; 
	
	public static String parse(String question){
		question = question.replace("{", "cbs~");
		question = question.replace("}", "cbe~");
		question = question.replace("(", "ibs~");
		question = question.replace(")", "ibe~");
		question = question.replace("'", "sp~");
		question = question.replace(",", COMMA_SEPARATOR);
		question = question.replace("\"", "dp~");
		return question;
	}
	public static String format(String question){
		question = question.replace("cbs~","{");
		question = question.replace("cbe~","}");
		question = question.replace("ibs~","(");
		question = question.replace("ibe~",")");
		question = question.replace("sp~","'");
		question = question.replace(COMMA_SEPARATOR,",");
		question = question.replace("dp~","\"");
		return question;
	}
}
