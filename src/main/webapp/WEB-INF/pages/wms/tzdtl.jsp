<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>

<div style="font-size:15px;">
	<ul style="font-size:12px;">
		<li>
			<strong>第一书记:</strong>
			<em>【姓名】</em><a href="#" onclick="ajaxLoadDaialog({url:'/editPerson',title:'人员信息',width:600,height:500,beforeDialogOpen:undefined,afterDialogOpen:undefined,data:{personId:'${person5.personId}',from:'list'}})">${person5.name } </a>
			|<em>【性别】</em>${person5.gender } | <em>【年龄】</em>${person5.age } | <em>【学历】</em>${person5.education } | <em>【派驻单位及职务】</em>${partyRole5.roleAttached1 }
		</li>
	</ul>
	<div class="col-sm-12" align="center"><u>调研座谈会情况</u></div>
	<legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">调研座谈会情况</legend>
	<dl class="dl-horizontal">
		<dt>时间</dt>
		<dd>${tzDyzth.tzDate}</dd>
		<dt>地点</dt>
		<dd>${tzDyzth.address}</dd>
		<dt>会议内容</dt>
		<dd>${tzDyzth.content}</dd>
	</dl>
	<div class="col-sm-12" align="center"><u>带好班子情况</u></div>
	<legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">指导参与组织生活情况</legend>
	<dl class="dl-horizontal">
		<dt>时间</dt>
		<dd>${tzDhbz.zdzzshTime}</dd>
		<dt>会议名称</dt>
		<dd>${tzDhbz.zdzzhyName}</dd>
	</dl>
	<legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">后备干部帮带情况</legend>
	<dl class="dl-horizontal">
		<dt>人数</dt>
		<dd>${tzDhbz.hbgbNum}</dd>
		<dt>帮带方式</dt>
		<dd>${tzDhbz.bdfs}</dd>
	</dl>
	<legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">培养积极分子情况</legend>
	<dl class="dl-horizontal">
		<dt>人数</dt>
		<dd>${tzDhbz.pyjjfzNum}</dd>
		<dt>姓名</dt>
		<dd>${tzDhbz.pyjjfzName}</dd>
	</dl>
	<div class="col-sm-12" align="center"><u>助推经济情况</u></div>
	<legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">制定村级发展规划情况</legend>
	<dl class="dl-horizontal">
		<dt>名称</dt>
		<dd>${tzZtjj.zdcjfzghName}</dd>
		<dt>进展情况</dt>
		<dd>${tzZtjj.zdcjfzghStatus}</dd>
	</dl>
	<legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">协调资金、项目、信息情况</legend>
	<dl class="dl-horizontal">
		<dt>类别</dt>
		<dd>${tzZtjj.xtzjxmType}</dd>
		<dt>用途</dt>
		<dd>${tzZtjj.xtzjxmPurpose}</dd>
	</dl>
	<legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">培养致富能手情况</legend>
	<dl class="dl-horizontal">
		<dt>姓名</dt>
		<dd>${tzZtjj.pyzfnsName}</dd>
		<dt>掌握技能</dt>
		<dd>${tzZtjj.pyzfnsSkill}</dd>
	</dl>
	<div class="col-sm-12" align="center"><u>服务群众情况</u></div>
	<legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">解决群众实际困难情况</legend>
	<dl class="dl-horizontal">
		<dt>个数</dt>
		<dd>${tzFwqz.jjsjknNum}</dd>
		<dt>具体问题</dt>
		<dd>${tzFwqz.jjsjknProblem}</dd>
	</dl>
	<legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">建设基础设施情况</legend>
	<dl class="dl-horizontal">
		<dt>个数</dt>
		<dd>${tzFwqz.jsjcssNum}</dd>
		<dt>具体设施</dt>
		<dd>${tzFwqz.jsjcssDtl}</dd>
	</dl>
	<legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">便民服务信息公示情况</legend>
	<dl class="dl-horizontal">
		<dt>是否公示</dt>
		<dd>${tzFwqz.bmfuxxIsShow}</dd>
		<dt>公示形式</dt>
		<dd>${tzFwqz.bmfuxxShowType}</dd>
	</dl>
	<div class="col-sm-12" align="center"><u>化解矛盾隐患情况</u></div>
	<legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">走访党员群众情况</legend>
	<dl class="dl-horizontal">
		<dt>次数</dt>
		<dd>${tzHjmd.zfqzTimes}</dd>
		<dt>人次</dt>
		<dd>${tzHjmd.zfqzPersonNum}</dd>
	</dl>
	<legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">化解矛盾纠纷情况</legend>
	<dl class="dl-horizontal">
		<dt>个数</dt>
		<dd>${tzHjmd.hjmdjfNum}</dd>
		<dt>化解情况</dt>
		<dd>${tzHjmd.hjmdjfDtl}</dd>
	</dl>
	<legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">解决历史遗留问题情况</legend>
	<dl class="dl-horizontal">
		<dt>个数</dt>
		<dd>${tzHjmd.jjlsylwtNum}</dd>
		<dt>解决情况</dt>
		<dd>${tzHjmd.jjlsylwtDtl}</dd>
	</dl>
	<div class="col-sm-12" align="center"><u>规范民主管理情况</u></div>
	<legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">四议两公开运用情况</legend>
	<dl class="dl-horizontal">
		<dt>次数</dt>
		<dd>${tzGfmz.sylhgkTimes}</dd>
		<dt>具体事项</dt>
		<dd>${tzGfmz.sylhgkDtl}</dd>
	</dl>
	<legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">党群综合服务站运行情况</legend>
	<dl class="dl-horizontal">
		<dt>次数</dt>
		<dd>${tzGfmz.dyzhfwzTimes}</dd>
		<dt>办理事项</dt>
		<dd>${tzGfmz.dyzhfwzDtl}</dd>
	</dl>
	<legend style="color:#8C0D0D;font-size:1.5rem;margin-bottom:10px;">三资管理公示情况</legend>
	<dl class="dl-horizontal">
		<dt>公示个数</dt>
		<dd>${tzGfmz.szgsNum}</dd>
		<dt>公示时间</dt>
		<dd>${tzGfmz.szgsTime}</dd>
	</dl>
</div>