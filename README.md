18.06.27 =================================

- multipartResolver 를 활용한 WAS에 이미지(파일) 업로드
	<beans:bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		<beans:property name="resolveLazily" value="true" />
	</beans:bean>
  
- fileUtil.setMultipartList() 메서드를 활용해서 Request 안에 있는 MultipartHttpServletRequest multipartRequest 값을 찾아서 파일을 받고, 데이터로 만든다.

* NativeWebRequest webRequest
  - HttpServletRequest request = (HttpServletRequest)webRequest.getNativeRequest();
    - MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
    
이렇게 값을 가져온다.
