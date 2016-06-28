package domain.valueo;

import util.WordWrapper;

public class Text extends Value{
	public static final int MAX_LINE_COLUMS = 35*2;

	private String text;	// 本文
	private String indetedText;

	/* コンストラクタ */
	public Text(String text){
		super();
		if( text == null )
			text = "";
		this.text = text;
		indetedText = WordWrapper.wordWrapp(text, MAX_LINE_COLUMS);
	}

	public String getIndetedText() {
		return indetedText;
	}

	// 本文を取得
	public String getText(){
		return text;
	}

	public void setIndent(TemplateItemType templateItemType, int intdentCnt) {
//		text = text.replaceAll("\r\n", "");
//		text = text.replaceAll("\r", "");
//		text = text.replaceAll("\n", "");

		String[] lins = WordWrapper.getLins( text, MAX_LINE_COLUMS - intdentCnt);

		StringBuffer buf = new StringBuffer();
		for( String line : lins)
		{
			templateItemType.addIndent( buf, intdentCnt);

//			for( int i = 0; i< intdentCnt ; i++ )
//			{
//				buf.append("  ");
//			}

			buf.append(line);
		}
		indetedText  = buf.toString();
	}

}
