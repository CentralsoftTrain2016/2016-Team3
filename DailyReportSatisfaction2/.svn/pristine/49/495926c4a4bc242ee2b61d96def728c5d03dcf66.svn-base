package domain.valueo;

public enum TemplateItemType {
	NORMAL_TEXT {
		@Override
		public void addIndent(StringBuffer buf, int intdentCnt) {
			for( int i = 0; i< intdentCnt ; i++ )
			{
				buf.append("  ");
			}
		}
	},
	GOOGLE_SHEET {
		@Override
		public void addIndent(StringBuffer buf, int intdentCnt) {
			for( int i = 0; i< intdentCnt ; i++ )
			{
				buf.append("  ");
			}

		}
	},
	MAIL_QUOTATION {
		@Override
		public void addIndent(StringBuffer buf, int intdentCnt) {

			for( int i = 0; i< intdentCnt ; i++ )
			{
				if( i == 0 )
					buf.append("> ");
				else
					buf.append("  ");
			}

		}
	};

	public abstract void addIndent(StringBuffer buf, int intdentCnt);


}
