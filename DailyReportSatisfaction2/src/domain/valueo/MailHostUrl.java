package domain.valueo;

public class MailHostUrl extends Value{
	private String url;

	public static MailHostUrl getInstanceWithMaintain(String url) throws InputRequiredException
	{
			return new MailHostUrl(reduceMojibake(url) );

	}


	public MailHostUrl(String url) throws InputRequiredException {
		super();
		if(url ==null || url.equals(""))
			throw new InputRequiredException();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	@Override
	public String toString() {
		return url;
	}

}
