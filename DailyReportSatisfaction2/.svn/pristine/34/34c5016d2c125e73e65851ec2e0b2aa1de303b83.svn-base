package domain.valueo;

import util.AesEncryptUtil;

public class MailPassword extends Value{
	public enum  EncriptedState {DECRIPTED,ENCRIPTED};

	private EncriptedState encriptedState;
	private String password;

	public MailPassword(String password) throws InputRequiredException {
		super();
		if(password ==null || password.equals(""))
			throw new InputRequiredException();
		this.encriptedState = EncriptedState.DECRIPTED;
		this.password = password;
	}


	public MailPassword(String password, EncriptedState encriptedState) throws InputRequiredException {
		super();
		if(password ==null || password.equals(""))
			throw new InputRequiredException();
		this.encriptedState = encriptedState;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void decriptPassword() {
		if(encriptedState != EncriptedState.ENCRIPTED)
		{
			throw new RuntimeException("暗号化されていません。");
		}
		encriptedState = EncriptedState.DECRIPTED;
		password = AesEncryptUtil.decrypt(password);
	}

	public void encriptPassword() {
		if(encriptedState != EncriptedState.DECRIPTED)
		{
			throw new RuntimeException("暗号化されています。");
		}
		encriptedState = EncriptedState.ENCRIPTED;
		password = AesEncryptUtil.encrypt(password);
	}

	@Override
	public String toString() {
		return password;
	}


	public static MailPassword getInstanceWithMaintain(String parameter) throws InputRequiredException {
		return new MailPassword(reduceMojibake(parameter) );
	}


}
