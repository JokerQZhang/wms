function ajaxSubmitFormUpdateAreas(form, target, callback, checkajaxformsubmit) {
   //waitSpinnerShow();
   //隐藏报错信息
//   hideErrorContainer = function() {
//       jQuery('#content-messages').html('');
//       jQuery('#content-messages').removeClass('errorMessage').fadeIn('fast');
//   }
//   updateFunction = function(data) {
//       if (data._ERROR_MESSAGE_LIST_ != undefined || data._ERROR_MESSAGE_ != undefined) {
//           if (!jQuery('#content-messages').length) {
//              //add this div just after app-navigation
//              if(jQuery('#content-main-section')){
//                  jQuery('#content-main-section' ).before('<div id="content-messages" onclick="hideErrorContainer()"></div>');
//              }
//           }
//           jQuery('#content-messages').addClass('errorMessage');
//          if (data._ERROR_MESSAGE_LIST_ != undefined && data._ERROR_MESSAGE_ != undefined) {
//              jQuery('#content-messages' ).html(data._ERROR_MESSAGE_LIST_ + " " + data._ERROR_MESSAGE_);
//          } else if (data._ERROR_MESSAGE_LIST_ != undefined) {
//              jQuery('#content-messages' ).html(data._ERROR_MESSAGE_LIST_);
//          } else {
//              jQuery('#content-messages' ).html(data._ERROR_MESSAGE_);
//          }
//          jQuery('#content-messages').fadeIn('fast');
//       } else {
//           if (jQuery('#content-messages').length) {
//               jQuery('#content-messages').html('');
//               jQuery('#content-messages').removeClass('errorMessage').fadeIn("fast");
//           }
//           ajaxUpdateAreas(areaCsvString);
//       }
//       waitSpinnerHide();
//   }
   if(typeof(checkajaxformsubmit) != "undefined" && !checkajaxformsubmit()){
	   return false;
   }
   jQuery.ajax({
       type: "POST",
       url: jQuery(form).attr("action"),
       data: jQuery(form).serialize(),
       success: function(data) {
    	   if(typeof(target) != "undefined"){
    		   $(target).html(data);
    	   }
    	   if(typeof(callback) != "undefined"){
    		   callback(data);
    	   }
    	   return false;
       }
   });
   return false;
}
//动态更新某个区域
function ajaxUpdateArea(areaId, target, targetParams) {
	loadingEffect($("#"+areaId));
    jQuery.ajax({
        url: target,
        type: "POST",
        data: targetParams,
        success: function(data) {
            jQuery("#" + areaId).html(data);
            loadingEffectOff($("#"+areaId));
        },
        error: function(data) {loadingEffectOff($("#"+areaId))}
    });
}
//翻页
function formPage(form, pageIndex){
	$(form).find("input[name='page.pageIndex']").val(pageIndex);
	$(form).submit();
	$(form).find("input[name='page.pageIndex']").val('');
}
//动态dialog
function ajaxLoadDaialog(options){
	if(typeof options.beforeDialogOpen != "undefined"){
		var beforeDialogOpen = options.beforeDialogOpen;
		if(!beforeDialogOpen()){
			return false;
		}
	}
	var url = options.url;
	var data = typeof options.data == "undefined" ? {} : options.data;
	var title = typeof options.title == "undefined" ? "" : options.title;
	var width = typeof options.width == "undefined" ? "600" : options.width;
	var height = typeof options.height == "undefined" ? "400" : options.height;
	var buttons = typeof options.buttons == "undefined" ? [] : options.buttons;
	var dialog = $('<div style="display:none;font-size:1.2em;" id="jokerdialogframexixi"></div>').appendTo('body');
	dialog.load(
			url,
			data,
			function (responseText, textStatus, XMLHttpRequest) {
				$(dialog).dialog({
					title:title,
					modal:true,
					buttons:buttons,
					close: function(event, ui) {
		            	$(dialog).remove();
		            },
		            open: function(event, ui) {
		            	$(".ui-dialog").attr("style",$(".ui-dialog").attr("style")+"font-size:80%;");
		            	if(typeof options.afterDialogOpen != "undefined"){
		            		var afterDialogOpen = options.afterDialogOpen;
		            		afterDialogOpen();
		            	}
		            },
		            width:width,
					height:height
				});
			}
	);
	return false;
}
//通用列表点击表示选择该行记录之后执行的操作，取出该行的数据并返回给回调函数
function commonTableListSelect(tr,callback){
	var tds = $(tr).children("td");
	var rowData = [];
	if(tds != null && $(tds).length>0){
		for(var i=0; i<$(tds).length; i++){
			//提出按钮a，取a下面的html()
			var td = $(tds)[i];
			var tda = $(td).children("a");
			if($(tda).length>0){
				rowData[i] = $(tda).html();
			}else{
				rowData[i] = $(td).html();
			}
		}
	}
	//兄弟row的style去掉
	var siblingstr = $(tr).siblings("tr");
	if(siblingstr != null && $(siblingstr).length>0){
		$(siblingstr).attr("style","");
	}
	$(tr).attr("style","background:#dff0d8;");
	if(typeof(callback) != "undefined"){
		callback(rowData);
	}
}
function loadingEffect(loadingarea){
	//组织效果叠加
	$(loadingarea).find("div[role='jokerloading']").remove();
	var mask = $("<div role='jokerloading' class='modal-backdrop fade in' align='center'><img src='/images/waiting.gif'></div>");
	
	var height = $(loadingarea).outerHeight();
	var width = $(loadingarea).outerWidth();
	$(mask).width(width);
	$(mask).height(height);
	$(mask).css("line-height",height+"px");
	$(loadingarea).append($(mask));
}
function loadingEffectOff(loadingarea){
	$(loadingarea).find("div[role='jokerloading']").remove();
}
function disableItem(item){
	$(item).attr("disabled", "disabled");
}
function enableItem(item){
	$(item).removeAttr("disabled");
}
//日起选择器:
function getDatePicker(element){
	$(element).datepicker({dateFormat:'yy-mm-dd',altFormat:'yy-mm-dd' ,showAnim:"fadeIn",duration:0,minDate: "-10y", maxDate:"2y",numberOfMonths: 1,
        showButtonPanel: true,autoSize: true ,
        monthNamesShort: ['\u4E00\u6708','\u4E8C\u6708','\u4E09\u6708','\u56DB\u6708','\u4E94\u6708','\u516D\u6708','\u4E03\u6708','\u516B\u6708','\u4E5D\u6708','\u5341\u6708','\u5341\u4E00\u6708','\u5341\u4E8C\u6708'],
        monthNames: ['\u4E00\u6708','\u4E8C\u6708','\u4E09\u6708','\u56DB\u6708','\u4E94\u6708','\u516D\u6708','\u4E03\u6708','\u516B\u6708','\u4E5D\u6708','\u5341\u6708','\u5341\u4E00\u6708','\u5341\u4E8C\u6708'],//['һ��','����','����','����','����','����','����','����','����','ʮ��','ʮһ��','ʮ����'],
        nextText: '\u4E0B\u4E00\u6708',
        prevText: '\u4E0A\u4E00\u6708' ,
        dayNames: ['\u661F\u671F\u5929','\u661F\u671F\u4E00', '\u661F\u671F\u4E8C', '\u661F\u671F\u4E09', '\u661F\u671F\u56DB', '\u661F\u671F\u4E94', '\u661F\u671F\u516D'],//['������','����һ', '��', '��', '��', '��', '��'],'%u661F%u671F%u5929'
        dayNamesMin: ['\u65E5','\u4E00', '\u4E8C', '\u4E09', '\u56DB', '\u4E94', '\u516D'],
        currentText: '\u4ECA\u65E5',
        closeText: '\u5173\u95ED', 
    	changeMonth: true,
    	changeYear: true
	 });
}