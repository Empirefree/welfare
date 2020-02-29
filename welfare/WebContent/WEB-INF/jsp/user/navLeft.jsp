<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript" src="${pwd}/js/formUtil.js"></script>
<link rel="stylesheet" type="text/css" href="${pwd}/css/leaves.css" />
<div class="box-body box-profile">
	<a href="#" target="_blank">
		<img class="profile-user-img img-responsive img-circle" src="${pwd}/images/fantasy.png" alt="User profile picture">
	</a>
	<h3 class="profile-username text-center">${user.username }</h3>
	<p class="text-muted text-center">已实名</p>
	<ul class="list-group list-group-unbordered">
		<li class="list-group-item">
			<b>捐赠物品</b> <a href="${pwd}/user/userDonation" class="pull-right">${num1 }</a>
		</li>
		<li class="list-group-item">
			<b>领取捐赠</b> <a href="${pwd}/user/userReceived" class="pull-right">${num2 }</a>
		</li>
	</ul>
	
	<ul class="nav nav-pills nav-stacked" style="text-align: center;">
		<li><a href="${pwd }/user/userMain">我的主页</a></li>
		<li><a href="${pwd }/user/userInfo">账号管理</a></li>
		<li><a href="${pwd }/user/userPublishActinfo">发起求助</a></li>
		<li><a href="${pwd }/user/userMsg">消息管理</a></li>
	</ul>
	<div class="box-header with-border">
	</div>
	<div class="clear"></div>
	<a href="javascript:void(0)" class="btn btn-primary btn-block follow col-md-6" data-uid="139" data-isfollow="0" data-toggle="modal" data-target="#myModal">
		<span class="default-text"><b>联系管理员</b></span>
		<span class="hover-text"><b>联系管理员</b></span>
	</a>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">联系管理员</h4>
            </div>
            <div class="modal-body">
            	 <form action="${pwd }/user/leaveidea/addLeaveidea" method="post" class="form-horizontal">
            		<div class="form-group">
            			<input type="hidden" name="ideaid" value="0">
					  </div>
					  <div class="form-group">
					    <label for="lastname" class="col-sm-2 control-label">问题</label>
					    <div class="col-sm-10">
   						 <textarea class="form-control" name="comment" rows="3" check="checkNotEmpty(this)" placeholder="您的问题"></textarea>
					    </div>
					  </div>
					  <div class="form-group">
					    <div class="col-md-12">
					      <button type="button" class="btn btn-default col-md-2 col-md-offset-5" onclick="checkForm(this)">提交</button>
					    </div>
					  </div>
            	</form>
			</div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
	<script>
		function submitComment(obj){
			
		}
	</script>
	<script type="text/javascript" src="${pwd}/userInfoStatic/jquery.min.js"></script>
    <script type="text/javascript" src="${pwd}/userInfoStatic/bootstrap.min.js"></script>