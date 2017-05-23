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
        <script language="javascript" type="text/javascript">
            
            //开通或暂停、删除
            function setState(id,state) {
            	var r=false;
            	if(state=="0"){
            		r = window.confirm("确定要开通此账务账号吗？");
            	}else if(state=="2"){
            		r = window.confirm("确定要删除此账务账号吗？\r\n删除后将不能恢复，且会删除其下属的所有业务账号。");
            	}else if(state=="1"){
            		r = window.confirm("确定要暂停此账务账号吗？");
            	}
              
                if(r){
					window.location.href="changeAccountState.action?id="+id+"&state="+state;
				}
            }
            
            //改变查看页数
			function changePage(p,idcardNum,name,loginName,state){
				//alert("11111111111111");
				$("#page").val(p);
				$("#idcardNum").val(idcardNum);
				$("#name").val(name);
				$("#loginName").val(loginName);
				$("#state").val(state);
				$("#submit").trigger("click");
			}            
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="images/logo.png" alt="logo" class="left"/>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">                        
            <ul id="menu">
                <li><a href="index.jsp" class="index_off"></a></li>
                <li><a href="../role/role_list.jsp" class="role_off"></a></li>
                <li><a href="<%=request.getContextPath() %>/WEB-INF/admin/admin_list.jsp" class="admin_off"></a></li>
                <li><a href="showFee.action" class="fee_off"></a></li>
                <li><a href="<%=request.getContextPath() %>/WEB-INF/account/account_list.jsp" class="account_on"></a></li>
                <li><a href="<%=request.getContextPath() %>/WEB-INF/service/service_list.jsp" class="service_off"></a></li>
                <li><a href="<%=request.getContextPath() %>/WEB-INF/bill/bill_list.jsp" class="bill_off"></a></li>
                <li><a href="<%=request.getContextPath() %>/WEB-INF/report/report_list.jsp" class="report_off"></a></li>
                <li><a href="<%=request.getContextPath() %>/WEB-INF/user/user_info.jsp" class="information_off"></a></li>
                <li><a href="<%=request.getContextPath() %>/WEB-INF/user/user_modi_pwd.jsp" class="password_off"></a></li>
            </ul>            
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            
                <!--查询-->
              <s:form theme="simple" action="showAccount" method="post">
                <div class="search_add">                        
                    <div>身份证：<input id="idcardNum" type="text" name="idcardNo" value="${idcardNo}" class="text_search" onfocus='if(value=="不验证"){value=""};' onblur="if(value==''){value='不验证'};"/></div>                            
                    <div>姓名：<input id="name" type="text" name="realName" class="width70 text_search" value="${realName}" onfocus="if(value=='不验证'){value=''};" onblur="if(value==''){value='不验证'};"/></div>
                    <div>登录名：<input id="loginName" type="text"  name="loginName" value="${loginName}" class="text_search"" onfocus="if(value=='不验证'){value=''};" onblur="if(value==''){value='不验证'};"/></div>
              		
                    <div>
                        状态：				
                        <s:select id="state" name="state" list="#{'-1':'全部','0':'开通','1':'暂停','2':'删除'}" value="state" cssClass="select_search"></s:select>
                        <input name="pageString" type="hidden" id="page" value="1"/>
                    </div>
                    <div><input id="submit" type="submit" value="搜索" class="btn_search" /></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='account_add.html';" />
                </div>  
              </s:form>
                <!--删除等的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功，且已删除其下属的业务账号！
                </div>   
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th>账号ID</th>
                        <th>姓名</th>
                        <th class="width150">身份证</th>
                        <th>登录名</th>
                        <th>状态</th>
                        <th class="width100">创建日期</th>
                        <th class="width150">上次登录时间</th>                                                        
                        <th class="width200"></th>
                    </tr>
                    
                    <s:iterator value="accountList" var="account">
                    	<s:if test="STATUS==\"0\"">
                    		<tr>
		                        <td>${account.ID }</td>
		                        <td><a href="account_detail.html">${account.REAL_NAME}</a></td>
		                        <td>${account.IDCARD_NO }</td>
		                        <td>${account.LOGIN_NAME }</td>
		                        <td>开通</td>
		                        <td>${account.CREATE_DATE }</td>
		                        <td>${account.LAST_LOGIN_TIME}</td>                            
		                        <td class="td_modi">
		                            <input type="button" value="暂停" class="btn_pause" onclick="setState(${account.ID},'1');" />
		                            <input type="button" value="修改" class="btn_modify" onclick="location.href='account_modi.html';" />
		                            <input type="button" value="删除" class="btn_delete" onclick="setState(${account.ID},'2');" />
		                        </td>
		                    </tr>
                    	</s:if>
                    	
                    	<s:if test="STATUS==\"1\"">
                    		<tr>
		                        <td>${account.ID }</td>
		                        <td><a href="account_detail.html">${account.REAL_NAME}</a></td>
		                        <td>${account.IDCARD_NO }</td>
		                        <td>${account.LOGIN_NAME }</td>
		                        <td>暂停</td>
		                        <td>${account.CREATE_DATE }</td>
		                        <td>${account.LAST_LOGIN_TIME}</td>                            
		                        <td class="td_modi">
		                            <input type="button" value="开通" class="btn_start" onclick="setState(${account.ID},'0');" />
		                            <input type="button" value="修改" class="btn_modify" onclick="location.href='account_modi.html';" />
		                            <input type="button" value="删除" class="btn_delete" onclick="setState(${account.ID},'2');" />
		                        </td>
		                     </tr>
                    	</s:if>
                    	
                    	<s:if test="STATUS==\"2\"">
                    		<tr>
		                        <td>${account.ID }</td>
		                        <td><a href="account_detail.html">${account.REAL_NAME}</a></td>
		                        <td>${account.IDCARD_NO }</td>
		                        <td>${account.LOGIN_NAME }</td>
		                        <td>删除</td>
		                        <td>${account.CREATE_DATE }</td>
		                        <td>${account.LAST_LOGIN_TIME}</td>                            
		                        <td class="td_modi">
		                        </td>
		                     </tr>
                    	</s:if>
                    	
                    </s:iterator>        
                    
                </table>
                <p>业务说明：<br />
                1、创建则开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、暂停账务账号，同时暂停下属的所有业务账号；<br />                
                6、暂停后重新开通账务账号，并不同时开启下属的所有业务账号，需要在业务账号管理中单独开启；<br />
                7、删除账务账号，同时删除下属的所有业务账号。</p>
                </div>                   
                <!--分页-->
                <div id="pages">
                  <!--
                    <a href="showAccount.action?page=1">首页</a>
        	        <a href="showAccount.action?page=${page-1}">上一页</a>
                    <s:iterator begin="1" end="pageNum" var="p">
                    	<a href="showAccount.action?page=${p}">${p}</a>
                    </s:iterator>
                    <a href="showAccount.action?page=${page+1}">下一页</a>
                    <a href="showAccount.action?page=${pageNum}">末页</a>
                  -->  
                    <a href="#" onclick="changePage(1,'${idcardNo}','${realName}','${loginName}','${state}');">首页</a>
        	        <a href="#" onclick="changePage(${page-1},'${idcardNo}','${realName}','${loginName}','${state}');">上一页</a>
                    <s:iterator begin="1" end="pageNum" var="p">
                    	<a href="#" onclick="changePage(${p},'${idcardNo}','${realName}','${loginName}','${state}');">${p}</a>
                    </s:iterator>
                    <a href="#" onclick="changePage(${page+1},'${idcardNo}','${realName}','${loginName}','${state}');">下一页</a>
                    <a href="#" onclick="changePage(${pageNum},'${idcardNo}','${realName}','${loginName}','${state}');">末页</a>
                </div>                    
           
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)加拿大达内IT培训集团公司 </p>
        </div>
    </body>
</html>
