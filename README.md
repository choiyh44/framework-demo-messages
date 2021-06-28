# framework-demo-messages
## 다국어 메시지 파일 적용 방법

1. application.yml 파일에 메시지 파일명(경로포함)을 등록한다.

```
spring:
  messages:
    basename:
      messages.common.common,
      messages.main.main
```

2. src/main/resources 경로 아래에 메시지 폴더를 생성하고 메시지 파일 작성한다.

```
messages/common/common_en.properties
messages/common/common_ko.properties
messages/common/common.properties
messages/main/main_en.properties
messages/main/main_ko.properties
messages/main/main.properties
```

3. 프로그램에서 메시지 키로 메시지 텍스트를 불러오도록 사용한다.

```
        <h1 th:text="#{main.text.hi}">Welcome!</h1>
        <p>This is <span th:text="#{common.text.system_name}">program</span> messages demo page.</p>
```

## 로케일 변경/유지 방법

1. 로케일 설정에 로케일 변경 interceptor를 생성한다.:

```
@Configuration
public class LocaleConfig implements WebMvcConfigurer {

	@Bean
	public CookieLocaleResolver localeResolver() {
		CookieLocaleResolver resolver = new CookieLocaleResolver();
		resolver.setDefaultLocale(Locale.KOREAN); // 기본언어는 한국어
		// resolver.setCookieMaxAge(3600*24*365); // 설정유지시간은 365일
	    return resolver;
	}
	
	/**
	 * requestParameter name: lang 값으로 ko(한국어)/en(영어) 을 받으면 지정된 locale로 변경된다.
	 * @return
	 */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
    
}
```

2. 로케일이 변경: 파리미터명이 lang인 경우 해당 파라미터 값으로 로케일이 변경된다. 변경사항은 쿠키로 관리되는데 쿠키 존속 기간은 설정에서 변경하면된다. 
