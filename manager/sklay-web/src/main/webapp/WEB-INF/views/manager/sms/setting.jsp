<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../include.jsp"%>
	<ul class="nav nav-tabs">
	    <li <c:if test="${'api'  eq active}"> class="active" </c:if>><a href="#widget-api" data-toggle="tab">短信API配置</a></li>
	    <li><a href="#widget-info" data-toggle="tab">短信统计</a></li>
	    <li <c:if test="${'phone' eq active}"> class="active" </c:if>><a href="#widget-phone" data-toggle="tab">手机号段</a></li>
	</ul>
	<div class="tab-content " >
		<div class="tab-pane <c:if test="${'api' eq active}"> active </c:if>" id="widget-api">
			<form class="form-horizontal" action="${ctx }/admin/sms/setting?active=api" method="post">
		      <div class="control-group">
		        <label class="control-label" for="inputSendUrl">短信API地址</label>
		        <div class="controls">
		          <input name="active" type="hidden" value="widget-api">
		          <input class="span5" type="text" name="sendUrl" id="inputSendUrl" placeholder="短信API地址" value="${smsSetting.sendUrl }">
		        </div>
		      </div>
		      <div class="control-group">
		        <label class="control-label" for="inputAccountId">短信帐号</label>
		        <div class="controls">
		          <input class="span3" type="text" name="accountId" id="inputAccountId" placeholder="短信帐号" value="${smsSetting.accountId }">
		        </div>
		      </div>
		      <div class="control-group">
		        <label class="control-label" for="inputPassword">短信帐号密码</label>
		        <div class="controls">
		          <input class="span3" type="text" name="password" id="inputPassword" placeholder="短信帐号密码" value="${smsSetting.password }">
		        </div>
		      </div>
		      <div class="control-group">
		        <label class="control-label" for="inputUserId">短信用户帐号Id</label>
		        <div class="controls">
		          <input class="span3" type="number" min="1" required="required"  name="userId" id="inputUserId" placeholder="短信用户帐号Id" value="${smsSetting.userId }">
		        </div>
		      </div>
		      
		      <div class="control-group">
		        <label class="control-label" for="inputPhysical">体检短信模版</label>
		        <div class="controls">
		        	<textarea rows="4" cols="4" class="span3" name="physical" id="inputPhysical" placeholder="体检短信模版">${smsSetting.physical }</textarea>
		        </div>
		      </div>
		      
		      <div class="control-group">
		        <label class="control-label" for="inputUserId">定位短信模版</label>
		        <div class="controls">
		        	<textarea rows="4" cols="4" class="span3" name="sos" id="inputSOS" placeholder="定位短信模版">${smsSetting.sos }</textarea>
		        </div>
		      </div>
		      
		      <div class="control-group">
		        <div class="controls">
		          <button type="button" class="btn btn-primary"  title="" data-delay="5" data-html="true" data-href='${ctx}/admin/sms/initSetting' data-original-title="消息...">提交</button>
		        </div>
		      </div>
		    </form>
		</div>
		
	    <div class="tab-pane" id="widget-info">
			<div class="row-fluid">
				<div class="column span6">
				  <div class="control-group">
			        <label class="control-label" for="inputRetCode">登入状态 : <strong>${smsInfo.retCode }</strong></label>
			      </div>
			      <div class="control-group">
			        <label class="control-label" for="inputMessage">服务器返回信息: <strong>${smsInfo.message}</strong></label>
			      </div>
			      <div class="control-group">
			        <label class="control-label" for="inputServerAddress">短信平台服务器地址: <strong>${smsInfo.smsServerAddress}</strong></label>
			      </div>
			      <div class="control-group">
			        <label class="control-label" for="inputUserRight" data-name="tooltip" data-toggle="tooltip" data-original-title="用户操作权限(0：没有权限；1：单用户、发送；2：单用户、发送接收；3：多用户、发送；4：多用户、发送接收)">用户操作权限: <strong>${smsInfo.userRight}</strong></label>
			      </div>
			      <div class="control-group">
			        <label class="control-label" for="inputToken" data-name="tooltip" data-toggle="tooltip" data-original-title="用户指纹（非常重要，用户据此执行其他操作）">token用户指纹: <strong>${smsInfo.token}</strong></label>
			      </div>
			      <div class="control-group">
			        <label class="control-label" for="inputAlive" data-name="tooltip" data-toggle="tooltip" data-original-title="最后与服务器心跳同步的时间(格式为hh:mm)">最后同步时间: <strong>${smsInfo.alive}</strong></label>
			      </div>
			      <div class="control-group">
			        <label class="control-label" for="inputSegmentUpperLimit" data-name="tooltip" data-toggle="tooltip" data-original-title="群发时，每个号段中允许的最多号码数量">群发数量: <strong>${smsInfo.segmentUpperLimit}</strong></label>
			      </div>
			      <div class="control-group">
			        <label class="control-label" for="inputLongSmsLen" data-name="tooltip" data-toggle="tooltip" data-original-title="【移动、联通短信的短信长度】">移动、联通短信长度: <strong>${smsInfo.longSmsLen}</strong></label>
			      </div>
			      <div class="control-group">
			        <label class="control-label" for="inputShortSmsLen">小灵通短信长度: <strong>${smsInfo.shortSmsLen}</strong></label>
			      </div>
			      <div class="control-group">
			        <label class="control-label" for="inputSmsStock">短信库余量: <strong>${smsInfo.smsStock}</strong></label>
			      </div>
				</div>
				<div class="column span6">
				  <div class="control-group">
			        <label class="control-label" for="inputDetailRetCode">登入状态: <strong>${smsDetail.retCode }</strong></label>
			      </div>
			      <div class="control-group">
			        <label class="control-label" for="inputDetailMessage">服务器返回信息: <strong>${smsDetail.message}</strong></label>
			      </div>
			      
			      <div class="control-group">
			        <label class="control-label" for="inputStockRemain">剩余短信: <strong>${smsDetail.stockRemain}</strong></label>
			      </div>
			      
			      <div class="control-group">
			        <label class="control-label" for="inputPoints" >用户积分: <strong>${smsDetail.points}</strong></label>
			      </div>
			      
			      <div class="control-group">
			        <label class="control-label" for="inputSendTotal">已发总数: <strong>${smsDetail.sendTotal}</strong></label>
			      </div>
			      <div class="control-group">
			        <label class="control-label" for="inputCurDaySend">今天已发送数量: <strong>${smsDetail.curDaySend}</strong></label>
			      </div>
				</div>
			</div>
		</div>
		<div class="tab-pane <c:if test="${'phone' eq active}"> active </c:if>" id="widget-phone">
			<form class="form-horizontal" action="${ctx }/admin/sms/paragraph?active=phone" method="post">
		      <div class="control-group">
		        <label class="control-label" for="inputMobile">移动</label>
		        <div class="controls">
		          <textarea rows="5" cols="5" class="span3" id="inputMobile" name="mobile">${smsSetting.mobile }</textarea>
		        </div>
		      </div>
		      <div class="control-group">
		        <label class="control-label" for="inputUnicom">联通</label>
		        <div class="controls">
		          <textarea rows="5" cols="5" class="span3" id="inputUnicom" name="unicom">${smsSetting.unicom }</textarea>
		        </div>
		      </div>
		      <div class="control-group">
		        <label class="control-label" for="inputTelecom">电信</label>
		        <div class="controls">
		          <textarea rows="5" cols="5" class="span3" id="inputTelecom" name="telecom">${smsSetting.telecom }</textarea>
		        </div>
		      </div>
		      <div class="control-group">
		        <div class="controls">
		          <button type="button" class="btn btn-primary"  title="" data-delay="5" data-html="true" data-href='${ctx}/admin/sms/initSetting' data-original-title="消息...">提交</button>
		        </div>
		      </div>
		  </form>
		</div>
	</div>


<script type="text/javascript" src="${ctx}/static/thirdparty/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="${ctx}/static/thirdparty/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/static/thirdparty/bootstrap-datetimepicker/css/datetimepicker.css">

<script type="text/javascript">
    $(document).ready(function() {
    	
 	    $('.form_datetime').datetimepicker({
 	        language:  'zh-CN',
 	        weekStart: 1,
 	        todayBtn:  1,
 			autoclose: 1,
 			todayHighlight: 1,
 			startView: 2,
 			forceParse: 0
 	    });
    });
</script>