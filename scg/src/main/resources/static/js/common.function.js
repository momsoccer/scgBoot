jQuery(function($){
   
	
	// jquery appendVal plugin
	$.fn.appendVal = function (newPart) {
		var result = this.each(function(){ 
			if( null != $(this).val() && "" != $(this).val() ){
				$(this).val( $(this).val() +","+ newPart );
			}else{
				$(this).val( $(this).val() + newPart); 
			}
		});
		return result;
	};
	$.fn.appendVal2 = function (newPart) {
		var result = this.each(function(){ 
			if (newPart != "" ) {
				if( null != $(this).val() && "" != $(this).val() ){
					$(this).val( $(this).val() +", "+ newPart );
				}else{
					$(this).val( $(this).val() + newPart); 
				}
			}
		});
		return result;
	};	


});


	//############팝업 열기################################
	function popWin(url, w, h, scroll, name) {
		var option = "status=no,height=" + h + ",width=" + w + ",resizable=no,left=0,top=0,screenX=0,screenY=0,scrollbars=" + scroll;

		commonPopWin = window.open(url, name, option);
		commonPopWin.focus();
	}
	
	function popWinForm(frm, url, w, h, scroll, name) {
		var frm	= frm;
		frm.action = url;
		frm.target = "sendWin";
		var option = "status=no,height=" + h + ",width=" + w + ",resizable=no,left=0,top=0,screenX=0,screenY=0,scrollbars=" + scroll;

		commonPopWin = window.open('', frm.target, option);
		commonPopWin.focus();
		frm.submit();
	}	

	function confirmPopWin(url, w, h, scroll, name){
		if (confirm("새 창으로 열립니다. 여시겠습니까?") == false)	return;

		var option = "status=no,height=" + h + ",width=" + w + ",resizable=no,left=0,top=0,screenX=0,screenY=0,scrollbars=" + scroll;

		commonPopWin = window.open(url, name, option);
		commonPopWin.focus();
	}
	function confirmTargetLocation(url){
		if (confirm("새 창으로 열립니다. 여시겠습니까?") == false)	return;
		var popWin = window.open('about:blank');
		popWin.location.href = url;
	}
	function targetLocation(url){
		var popWin = window.open('about:blank');
		popWin.location.href = url;
	}


	// 주소 검색 팝업
	var fnSearchAddr = (function(){
		popWin("/common/popup/addrSearch.asp", 500, 800, 'auto', 'addrSearchPop');
	});

	// 체크박스 무조건 체크 false 리턴 
	var fnSetUnChecked = (function(_objNm){
		var $obj	= $("input:checkbox[name=" + _objNm + "]");
		$obj[0].checked = false;
	});
	// 체크박스 무조건 체크 true 리턴 
	var fnSetChecked = (function(_objNm){
		var $obj	= $("input:checkbox[name=" + _objNm + "]");
		$obj[0].checked = true;
	});	

	
	// 페이징 이동 
    var fnPaging = (function(_p){
		if (parseInt(_p) < 1) return;
        var form = document.searchForm;

        $("input[name='pageIndex']").val( _p );
        form.submit();
    });

	// 페이징 Url 이동 
    var fnPagingUrl = (function(pageIndex, _url){
        var form = document.searchForm;
        $("input[name='pageIndex']").val( pageIndex );
        form.action = _url;
        form.submit();
    });

	// 페이지 이동
	var fnPage = (function(_url) {
        var form = document.searchForm;
        form.action = _url;
        //form.method = "get";
        form.submit();
	});

	// 상페 페이지 이동
	var fnView = (function(_idx, _url) {
        var form = document.searchForm;
		$("input[name='idx']").val( _idx );
        form.action = _url;
        form.method = "get";
        form.submit();
	});
	// 상페 페이지 이동
	var fnViewRnum = (function(_idx, _url, _num) {
        var form = document.searchForm;
		$("input[name='idx']").val( _idx );
		$("input[name='rnum']").val( _num );
        form.action = _url;
        form.method = "get";
        form.submit();
	});


	// 폼 등록 or 수정 취소 
    function fnCancel(_url) {
		if (! confirm("지금까지 작성한 내용은 삭제됩니다.\n그래도 취소 하시겠습니까?") ) 	return;	
		fnPage(_url);
	}
    

	// 게시물 삭제 
	function fnDelete(_url, _returnUrl){
        if (! confirm("입력하신 내용이 삭제됩니다.\n그래도 삭제하시겠습니까?") ) 	return;	            
		var frm = $("form[name=deleteForm]");
		var params = frm.serialize() ;
		$.post(
			_url,
			params,
			function(data){
				if (data.result == "S" ){
					alert("삭제 되었습니다.");
					fnPage(_returnUrl);
				}else{
					alert(data.result);
				}
			}
		);
	} 

	// 아이프레임 리사이즈 
    var fnIframeResize = (function(_objId){
        var iframeObj = document.getElementById(_objId);
        
        var childFrameHeight = iframeObj.contentWindow.document.body.offsetHeight;        

		$('#' + _objId).css('height',childFrameHeight);
       
        
    });
    
	var allImagesLoaded = (function() {

		var imagesloaded = 1;

		var images = document.images;

		for (var i = 0;i<images.length;i++)		{
				if(images[i].complete == false) {
						imagesloaded = 0;
				}else{
					if (images[i].width > imgWidth)
					   imgWidth = images[i].width;
				}
		}

		return imagesloaded;
	});	
	
    
	// 주소 복사 
	var fnUrlCopy = (function(id){		
		
		var url = location.href;
		var bResult = false;
		
		
		try {
		if( window.clipboardData ) {
			bResult = window.clipboardData.setData("Text", url);
		}else{
			temp = prompt("아래의 URL을 복사(Ctrl+C)하여\n원하는 곳에 붙여넣기(Ctrl+V)하세요.", url);
		}
		
		if( bResult == true) {
			alert("게시물 주소가 복사되었습니다.\nCtrl+V 로 붙여넣기 할 수 있습니다.");
			return;
		}  
		}catch(e){
		}
		
	});
	
	//페이스북 공유
	var fnShareFb = (function() {	
		var snsUrl		= location.href;

		popWin("http://www.facebook.com/sharer.php?u="+ encodeURIComponent( snsUrl ), '626', '436', 'yes', 'facebook_share_dialog');		

	});

	// 트위터 공유
	var fnShareTwitter = (function (){

		var snsTitle	= $(".sub_content h3").text();
		var snsUrl		= location.href;

		popWin("https://twitter.com/intent/tweet?url=" + encodeURIComponent(snsUrl) + "&amp;text=" + encodeURIComponent(snsTitle) + encodeURIComponent('\n'), 626, 436, "yes", "twitter_share_dialog");

	});	
	
	//카카오톡
	var fnShareKakaotalk = (function(snsImg){
	   var snsTitle = $(".sub_content h3").text();
	   Kakao.Link.sendTalkLink({
		  label: snsTitle,
		  image: {
			src: snsImg,
			width: '300',
			height: '200'
		  },
		  webLink: {
			text: "[Maison] 사이트로 이동",
			url: location.href  // 앱 설정의 웹 플랫폼에 등록한 도메인의 URL이어야 합니다.
		  }
		});


	});

	// 라인 
	var fnShareLine = (function (){
		var snsTitle = $(".sub_content h3").text();
		var content		= snsTitle + '\n' + location.href;
		location.href = "http://line.me/R/msg/text/?" + encodeURIComponent(content).replace(/\+/g, '%20');
	});

	// 상세 이메일 공유 
	var fnShareEmail = (function (){
		$("input[name=shareLink]").val(location.href);
		popWinForm(document.shareForm, '/common/popup/shareEmail.asp', 515, 480, 'no', 'shareEmail');
	});   

	// 상세 인쇄 
	var fnPrint = (function (){
		//window.print();
		$("#printArea").printArea();
	});   
	


	//select box 기본 값 남기고 삭제 하기
	var fnResetSelectBox = (function(formName,objName ){
	    $("form[name='"+formName+"'] select[name='"+ objName +"'] option").not("[value='']").remove();
	});

	// 숫자 세자리마다 콤마 찍기
	var setComma = (function(intStr) {
		intStr = makeTwo(intStr);
		var reg = /(^[+-]?\d+)(\d{3})/;
		intStr += '';
		while(reg.test(intStr))
			intStr = intStr.replace(reg, '$1' + ',' + '$2');
		return intStr;
	});
    
	// 숫자 1자리수 체크 하여 0 추가
	var makeTwo = (function(num) {
		var re = num;		
		if(num < 10) re = "0" + num;
		return re;
	});	

	var makeTwo2 = (function(num) {
		var re = num;		
		if(num.length < 2) re = "0" + num;
		return re;
	});			
		
	// 도메인 return; 
	var getDomain = (function(_url){
		 _url = _url.split('//');
		 _url = _url[1].substr(0, _url[1].indexOf('/'));
		 return _url;
	});		
	
	
	// 링크이동 로그인 여부 확인 	
	var isLoginLnk = (function(returnUrl){		
		if(isLogin == "False"){
			var loginConfirm = confirm("로그인을 하셔야 하는 서비스입니다.\n로그인 페이지로 이동하시겠습니까?");
			if( !loginConfirm )
				return false;

			if( !returnUrl || returnUrl == ''){
				location.href  = '/member/login/?returnUrl=' + encodeURIComponent(location.href);
				return;
			}
			location.href = '/member/login/?returnUrl=' + encodeURIComponent("http://" + getDomain(location.href) + returnUrl);
			return; 
		}else{
			location.href = returnUrl;
			return; 
		}
	});	
	
	// 로그인 폼 이동 확인
	var fnLoginConfirm = (function(){
		if (confirm("로그인이 필요한 서비스 입니다.\n로그인 페이지로 이동하시겠습니까?")) fnLoginForm();
	});

	// 로그인 링크 (로그인 후 현재 주소 or root 로 이동 )
    var fnLoginForm = (function() {
        var returnUrl   = location.href;

        if (returnUrl.indexOf("member") > -1) {
            returnUrl       = webRoot;
        }

        location.href = "/member/login/?returnUrl=" + encodeURIComponent(returnUrl);
    });
	
	// 로그아웃 
    var fnLogout = (function() {		
        var params  = "procType=logout";
        $.post(
            "/member/login/_proc.asp",
            params,
            function(data){
                if( data == null ){
                    alert( "전송 결과가 명확하지 않습니다. 관리자에게 문의하세요" );
                }
                if(data.result =="S"){
					alert("로그아웃 되셨습니다.");
                    location.replace(webRoot);
                }
            });
    });	
	// 첨부파일 삭제
	var deleteAttachFile = (function(fileIdx, thumbArea) {
		if ( ! confirm ("서버에 저장된 파일 모두 삭제되며 복구 할수 없습니다.\n정말 삭제 하시겠습니까?") ) {
			return ;
		}
		
        var params = "fileIdx=" + fileIdx ;

        $.post(
            "/web/common/asp/fileDel.asp",
            params,
            function(data){
                if(data.result =="S"){
                    alert("삭제 되었습니다.");                    
                    $("#" + thumbArea).remove();
					$("input[name=oldFileIdx]").val(0);
                }else if(data.result == "F"){
                    alert("삭제에 실패 했습니다");
                    return;
                }
            });		
		
	});
	
	// 상단 통합검색 
	var fnTopSearch = (function() {
		var frm		= $("form[name=topSearchForm]");		
		var obj		= $("input[name=tSearchKTemp]");
		if( fnFFChkNull(obj, "검색어", 'f' ) == false) { 
			return;
		}		
		
		frm.find("input[name=tSearchK]").val(obj.val());
		frm.attr("action", "/sub/search/");
		frm.submit();
	});
	
	var fnTagSearch = (function(_obj) {
		var obj	= $("input[name=tSearchKTemp]");
		obj.val($(_obj).text());		
		
		fnTopSearch();
	});	
	
	// 우편번호 검색 
    function fnPopSearchAddr(_mode) {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수
				var roadAdrFlag = ''; // 도로명 주소 사용 여부 (DB 저장용 )

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;
					roadAdrFlag = 'Y';

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
					roadAdrFlag = 'N';
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }
				
				if (_mode == "re"){
					document.getElementById("reZipCode1").value = data.postcode1;
					document.getElementById("reZipCode2").value = data.postcode2;
					document.getElementById("reAddr1").value = fullAddr;
					document.getElementById("reAddr2").focus();					
				}else{
					// 우편번호와 주소 정보를 해당 필드에 넣는다.
					document.getElementById("zipCode1").value = data.postcode1;
					document.getElementById("zipCode2").value = data.postcode2;
					document.getElementById("addr1").value = fullAddr;
					document.getElementById("roadAdrFlag").value = roadAdrFlag;
					// 커서를 상세주소 필드로 이동한다.
					document.getElementById("addr2").focus();
				}
            }
        }).open();
    }
	
	// 비동기 처리된 커스텀 셀렉트 박스 재 호출 
	var fnCallSelCustom = (function(){
		//sub list select box 
		var select = $('select.sel_box');
		select.change(function(){
				var select_name = $(this).children('option:selected').text();
				$(this).siblings('.custom_selbox').text(select_name);
		});	
	});



	//############쿠키 관련################################
	var setCookie = (function(strName, strValue, days) {
		var objExpireDate = new Date();

		objExpireDate.setDate(objExpireDate.getDate() + days); 
		
		document.cookie = strName + "=" + escape(strValue) + "; path=/; expires=" + objExpireDate.toGMTString() + ";";

		//alert(document.cookie);
	});
	
	var setCookie2 = (function(strName, strValue, day) {
		var objExpireDate = new Date();
		day = day || 1;
		objExpireDate.setDate(objExpireDate.getDate() + (24 * 60 * 60 * 1000 * day)); 
		
		document.cookie = strName + "=" + escape(strValue) + "; path=/; expires=" + objExpireDate.toGMTString() + ";";

		//alert(document.cookie);
	});

	var delCookie = (function(strName) {
		var objExpireDate = new Date();

		objExpireDate.setDate(objExpireDate.getDate() - 1);
		
		document.cookie = strName + "=;expires=" + objExpireDate.toGMTString();
	});

	var getCookie = (function (strName) {
		var strCookieName = strName + "=";
		var objCookie = document.cookie;
		
		if (objCookie.length > 0) 
		{
			var nBegin = objCookie.indexOf(strCookieName);
			
			if (nBegin < 0) 
			{
				return;
			}

			nBegin += strCookieName.length;
			
			var nEnd = objCookie.indexOf(";", nBegin);
			
			if (nEnd == -1) 
			{
				nEnd = objCookie.length;
			}
		}
		//alert(objCookie.substring(nBegin, nEnd));
		
		return unescape(objCookie.substring(nBegin, nEnd));
	});		

	function fnLayerMore(idx){
		$("input[name='idx']").val(idx);
		
		var chk = false;
		//var formData = new FormData();
		var html = "";
		if(!chk){
			$.ajax({
				url: '/kr/mainLayer.asp',
				data: $("#searchForm").serialize(),
				processData: false,
				contentType: false,
				type: 'GET',
				dataType : 'html',
				success: function(data){
					$('#mainLayer').html(data);
					$.fn.buildingPopup.show();
				}
			});
		}
    }

	function fnRelation(idx){
		$('#layerClose').click();
		fnLayerMore(idx);
	}
		