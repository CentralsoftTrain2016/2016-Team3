package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import domain.valueo.MailEnvironmentEnum;

public class PropertiesUtil {
	public static MailEnvironmentEnum isServer()
	{
		MailEnvironmentEnum ret=MailEnvironmentEnum.CLIENT;
		Properties properties = new Properties();

        String file = "C:/properties/saver.properties";

        InputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
            properties.load(inputStream);
            inputStream.close();

            // 値の取得
            System.out.println("serverName:" + properties.getProperty("serverName"));
            String isServerStr = properties.getProperty("isServer");
            System.out.println("isServer:" + isServerStr);

            Boolean isServer = Boolean.valueOf(isServerStr);
            if(isServer)
            	ret = MailEnvironmentEnum.SERVER;
            else
            	ret = MailEnvironmentEnum.CLIENT;
		}
		catch (IOException e)
		{
			System.out.println("プロパティーがありません（クライアント）");
			//e.printStackTrace();
		}

		return ret;
	}

}
