﻿<%@page pageEncoding="utf-8"  contentType="text/html; charset=utf-8" %>
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
        	$(function(){
        		//排序按钮的点击事件
	            function sort(btnObj) {
	                if (btnObj.className == "sort_desc")
	                    btnObj.className = "sort_asc";
	                else
	                    btnObj.className = "sort_desc";
	            }
	
	            //启用
	            $("#datalist .btn_start").click(function() {
	                var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
	                if(r){
	                	var id_td=$(this).parents("tr").children().get(0);
	                	var id=$(id_td).text().trim();
	                	//alert(id);
	                	location.href="startFee.action?id="+id;
	                }
	            });
	            
	            
	            //删除
	            $("#datalist .btn_delete").click(function() {
	                var r = window.confirm("确定要删除此资费吗？");
	                if(r){
	                	var id_td=$(this).parents("tr").children().get(0);
	                	var id=$(id_td).text().trim();
	                	alert(id);
	                	location.href="deleteFee.action?id="+id;
	                	document.getElementById("operate_result_info").style.display = "block";
	                }
	            });
	            
        	
        	
        	});
            
        </script>        
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="images/logo.png" alt="logo" class="left"/>
			<span>当前账号：<b>scott</b></span>
            <a href="#">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">                        
            <ul id="menu">
                <li><a href="../index.html" class="index_off"></a></li>
                <li><a href="../role/role_list.html" class="role_off"></a></li>
                <li><a href="../admin/admin_list.html" class="admin_off"></a></li>
                <li><a href="../fee/fee_list.html" class="fee_on"></a></li>
                <li><a href="showAccount.action" class="account_off"></a></li>
                <li><a href="../service/service_list.html" class="service_off"></a></li>
                <li><a href="../bill/bill_list.html" class="bill_off"></a></li>
                <li><a href="../report/report_list.html" class="report_off"></a></li>
                <li><a href="../user/user_info.html" class="information_off"></a></li>
                <li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>
            </ul>            
        </div>
        <!--导航区域结束-->
        <!--主要区域开始-->
        <div id="main">
            <form action="" method="">
                <!--排序-->
                <div class="search_add">
                    <div>
                        <input type="button" value="月租" class="sort_asc" onclick="sort(this);" />
                        <input type="button" value="基费" class="sort_asc" onclick="sort(this);" />
                        <input type="button" value="时长" class="sort_asc" onclick="sort(this);" />
                    </div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='showFeeAdd.action';" />
                </div> 
                <!--启用操作的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div>    
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th>资费ID</th>
                            <th class="width100">资费名称</th>
                            <th>基本时长</th>
                            <th>基本费用</th>
                            <th>单位费用</th>
                            <th>创建时间</th>
                            <th>开通时间</th>
                            <th class="width50">状态</th>
                            <th class="width200"></th>
                        </tr>                      
                       
                        <s:iterator value="costList" var="cost">
                        	<s:if test="STATUS==\"1\"">
	                        	<tr>
		                            <td>${cost.ID}</td>
		                            <td><a href="feeDetail.action?id=${cost.ID}&page=${page}">${cost.NAME}</a></td>
		                            <td>${cost.BASE_DURATION}小时</td>
		                            <td>${cost.BASE_COST}元</td>
		                            <td>${cost.UNIT_COST }元/小时</td>
		                            <td>${cost.CREATE_TIME}</td>
		                            <td>${cost.START_TIME}</td>
		                            <td>开通</td>
		                            <td>                                
	                           		 </td>
                        		</tr>
                        	</s:if>
                        	<s:if test="STATUS==\"0\"">
	                        	<tr>
		                            <td>${cost.ID}</td>
		                            <td><a href="feeDetail.action?id=${cost.ID}&page=${page}">${cost.NAME}</a></td>
		                            <td>${cost.BASE_DURATION}小时</td>
		                            <td>${cost.BASE_COST}元</td>
		                            <td>${cost.UNIT_COST }元/小时</td>
		                            <td>${cost.CREATE_TIME}</td>
		                            <td>${cost.START_TIME}</td>
		                            <td>暂停</td>
		                            <td>                                
		                                <input type="button" value="启用" class="btn_start"  />
		                                <input type="button" value="修改" class="btn_modify" onclick="location.href='showFeeModify.action?id=${cost.ID}';" />
		                                <input type="button" value="删除" class="btn_delete"  />
		                            </td>
                        		</tr>
                        	</s:if>
                        </s:iterator>
                    </table>
                    <p>业务说明：<br />
                    1、创建资费时，状态为暂停，记载创建时间；<br />
                    2、暂停状态下，可修改，可删除；<br />
                    3、开通后，记载开通时间，且开通后不能修改、不能再停用、也不能删除；<br />
                    4、业务账号修改资费时，在下月底统一触发，修改其关联的资费ID（此触发动作由程序处理）
                    </p>
                </div>
                <!--分页-->
                <div id="pages">
                	<a href="showFee.action?page=${page-1}">上一页</a>
                	<s:iterator begin="1" end="pageNum" var="p">
                		<s:if test="page==#p">
                			<a href="showFee.action?page=${p}" class="current_page" >${p}</a>
                		</s:if>
                		<s:else>
                			<a href="showFee.action?page=${p}">${p}</a>
                		</s:else>
                	</s:iterator>
                	<a href="showFee.action?page=${page+1}">下一页</a>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)加拿大达内IT培训集团公司 </p>
        </div>
    </body>
</html>
