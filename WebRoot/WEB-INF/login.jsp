<%@page pageEncoding="utf-8"  contentType="text/html; charset=utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>达内－NetCTOSS</title>
        <link type="text/css" rel="stylesheet" media="all" href="styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="styles/global_color.css" /> 
        <script type="text/javascript" src="js/jquery-1.4.3.js"></script>
        <script type="text/javascript">
        	$.fn.check=function(errorMsg,errorCtn){
        		var str=$(this).val().trim();
        		if(str==""||str==null){
					$(errorCtn).text(errorMsg);
					return false;
				}else{
					$(errorCtn).text("");
					return true;
				}
        	}
        	$(function(){
        		$(".login_button a").click(function(){
        			var name_check=$("#input_name").check("30长度的字母、数字和下划线","#name_error");
        			var pwd_check=$("#input_pwd").check("30长度的字母、数字和下划线","#pwd_error");
        			if(name_check==true&&pwd_check==true){
        				$("#form").submit();
        			}
        		});
        		
        		$("#vc_image").click(function(){
        			$(this).attr("src","verificationCode.action?timestamp="+new Date().getTime());
        		});
        		
        	});
        	
        </script>
        
    </head>
    <body class="index">
        <div class="login_box">
	        <form action="login.action" id="form" method="post">
	            <table>
	                <tr>
	                    <td class="login_info">账号：</td>
	                    <td colspan="2"><input name="name" type="text" class="width150" id="input_name"/></td>
	                    <td class="login_error_info" ><span class="required"  id="name_error"></span></td>
	                </tr>
	                <tr>
	                    <td class="login_info">密码：</td>
	                    <td colspan="2"><input name="pwd" type="password" class="width150" id="input_pwd"/></td>
	                    <td><span class="required"  id="pwd_error"></span></td>
	                </tr>
	                <tr>
	                    <td class="login_info">验证码：</td>
	                    <td class="width70"><input name="verCode" type="text" class="width70" id="input_vc"/></td>  
	                    <td><img src="verificationCode.action" alt="验证码" title="点击更换" id="vc_image"/></td>  
	                    <s:if test="ok=='vc_error'">
	                    	<td><span class="required" style="visibility: visible" id="vc_error">验证码错误</span></td>
	                    </s:if>                           
	                </tr>            
	                <tr>
	                    <td><br /><br /></td>
	                    <td class="login_button" colspan="2">
	                        <a href="#"><img src="images/login_btn.png" /></a>
	                    </td>  
	                    <s:if test="ok=='false'">
	                    	<td><span class="required" style="visibility: visible" id="login_error">用户名或密码错误，请重试</span></td> 
						</s:if>     
						<s:else>
							<td><span class="required" style="visibility: hidden" id="login_error">用户名或密码错误，请重试</span></td>
						</s:else>         
	                </tr>
	            </table>
	        </form>
        </div>
    </body>
</html>
