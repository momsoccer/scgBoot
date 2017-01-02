( function() {
		$(document).ready(function() {
			/**
			 *
			 * 
			 *
			 **/
			//=================================== event 전역함수 ==========================================
			
			//이벤트 관련 전역변수 등록
			$.fn.WndowEvent = new windowEvent();
			//이벤트 관련 함수
			var myWindowEvent = $.fn.WndowEvent;
			
			function windowEvent() {
				/*
				 * 스크롤 및 리사이즈 이벤트 컨트롤 클래스
				 * 
				 * event1:{type:"scroll", start:10, end:500, singleEvent:true, callBack:function(){}},
				 * event2:{type:"width"", start:10, end:500, singleEvent:false, callBack:function(){}}
				 *
				 */
				if(!(this instanceof windowEvent)){
					return new windowEvent();
				}
				
				var scope = this;
				
				var events = {},
					scrollEvents = {},
					resizeEvents = {},
					windowWidth,
					scrollTop;
				
				//리사이즈 이벤트
				$(window).resize(function() {
					scope.resizeUpdate();
				});
				//스크롤 이벤트 관련
				$(window).scroll(function() {
					scope.scrollUpdate();
				});
				
				//스크롤 및 리사이즈시 사용될 이벤트 추가
				this.addEvent = function(prop){
					for( var i in prop){
						if( events[i] != undefined )throw new Error("same property already existence");
					}
					events = $.extend(events, prop);
					conditionSetObj(prop);
					classifyEvents();
				}
				//개별 이벤트 속성 업데이트 
				this.updateProperty = function(name, prop) {
					updateProperty(name, prop);
				}
				//이벤트 강제로 실행
				this.update = function(){
					this.scrollUpdate();
					this.resizeUpdate();
				}
				//스크롤 이벤트 강제 실행
				this.scrollUpdate = function(){
					conditionSetObj(events);
					scrollTop = $(window).scrollTop();
					doEvent(scrollTop, scrollEvents);
				}
				//
				this.resizeUpdate = function(){
					conditionSetObj(events);
					windowWidth = window.innerWidth;
					doEvent(windowWidth, resizeEvents);
				}
				//이벤트 작동하지 않음
				this.activateEvent = function(name){
					events[name]["activate"] = true;
				}
				//이벤트 작동
				this.unActivateEvent = function(name){
					events[name]["activate"] = false;
				}
				//1번 실행되는 이벤트를 실행 전으로 리셋
				this.resetconditions = function(){
					if( arguments.length > 0 )
					{
						for( var i=0; i<arguments.length; i++){
							if(typeof arguments[i] == "object")conditionSetObj(arguments[i]);
							if(typeof arguments[i] == "string")conditionSetString(arguments[i]);
						}
					}else{
						conditionSetObj(events);
					}
					
				}
				
				function classifyEvents(){
					for (var i in events) {
						if( events[i] != undefined){
							if(events[i]["type"] == "scroll"){
								scrollEvents[i] = events[i]; 
							}else{
								resizeEvents[i] = events[i]; 
							}
						}
					}
				}
				
				function conditionSetObj(prop){
					for( var i in prop){
						if(prop[i]["singleEvent"] == true )prop[i]["isoccurred"] = false;
					}
				}
				
				function conditionSetString(name){
					if(events[name]["singleEvent"] == true )events[name]["isoccurred"] = false;
				}
				
				//속성 업데이트
				function updateProperty(name, prop) {
					$.extend( scrollEvents[name], prop );
				}
				//이벤트 싫행
				function doEvent(pos, prop){
					for( var i in prop ){
						if(prop[i]["activate"] == false)continue;
						if( pos >= prop[i]["start"] && pos < prop[i]["end"]){
							if( prop[i]["singleEvent"] == true ){
								if( prop[i]["isoccurred"] == false ){
									if( prop[i]["callBack"] ){
										prop[i]["callBack"](pos);
										prop[i]["isoccurred"] = true;
									}
								}
							}else{
								if( prop[i]["callBack"] )prop[i]["callBack"](pos);
							}
						}else{
							if( prop[i]["isoccurred"] == true)prop[i]["isoccurred"] = false;
						}
					}
				}
			}
			
			//=================================== 컨텐츠 관련  ==========================================
			
			var container = $("#container"),
				header = $("header"),
				mode;
			
			//국/영문 버튼
			var myLanguageBtn = new languageBtn();
			//페밀리 사이트
			var myFamilySite = new familySite();
			//모바일 우측하단 플로팅 버튼
			var myfloatingMenu = new floatingMenu();
			//top버튼
			var myTopBtn = new topBtn();
			//실적관련 팝업 
			var myPopupBuilding = new popupBuilding();
			//전역 변수 등록
			$.fn.buildingPopup = myPopupBuilding;
			
			//리사이즈 이벤트 등록 - 일반 페이지
			myWindowEvent.addEvent({
				//type:"resize", /*시작위치px*/start:0, /*종료위치px*/end:768, /*한번만 실행하는지*/singleEvent:true, callBack:function(){}
				//PC화면 (768이상)
				commonPc:{
					type:"resize",
					start:768, 
					end:Infinity, 
					singleEvent:true, 
					callBack:function(){
						//프로팅메뉴 닫기
						myfloatingMenu.floatingClose();
					}
				},
				
				topBtnPos:{
					type:"scroll",
					start:0, 
					end:Infinity, 
					singleEvent:true, 
					callBack:function(st){
						
						var currPos = st + (window.innerHeight - 50);
						var targetPos = $('footer').offset().top - 50;
						if( $('footer').offset().top > window.innerHeight ){
							if( currPos >= targetPos){
								myTopBtn.absolute();
							}else{
								myTopBtn.fixed();
							}
						}
					}
				}
			});
			
			myWindowEvent.resizeUpdate();
			//=================================== language button ========================================
			function languageBtn(){
				var list = $(".language");
				var btn = $(".language .sel-tit");
				var atag = $(".language a");
				
				btn.bind("click",function(e){
					e.preventDefault();
					list.toggleClass('on');
				});
			}
			
			//=================================== floatingMenu ==========================================
			
			function floatingMenu() {
				//모바일 둥둥이 버튼
				var floating = $(".floating"),
				    floatingMenus = $(".floating .floating-view a"),
				    floatingOpenBtn = $(".floating .off"),
				    floatingCloseBtn = $(".floating .floating-view .btx");

				init();

				this.open = false;
				//플로팅메뉴 닫기
				this.floatingClose = function() {
					if(floating.hasClass("on") == true)floatingClose();
				}
				
				function init() {
					defaultSet();
					addEvent();
				}
				//기본 셋
				function defaultSet() {
					floatingOpenBtn.css("z-index", "100");
				}
				//클릭 이벤트 관련
				function addEvent() {
					floatingOpenBtn.bind("click", function(e) {
						e.preventDefault();
						floatingOpen();
					});

					floatingCloseBtn.bind("click", function(e) {
						e.preventDefault();
						floatingClose();
					});
				}

				//모바일 우측하단 플로팅 버튼 오픈
				function floatingOpen() {
					
					floatingMenus.each(function(i) {
						
						$(this).css({"z-index":100});
						if( i == 0 ){
							$(this).css({x:0, y:0, opacity:0})
							.transition({x:0, y:-90, opacity:1, duration:300, delay:100});
						}else if(i==1){
							$(this).css({x:0, y:0, opacity:0})
							.transition({x:-69, y:-61, opacity:1, duration:300, delay:200});
						}else if(i==2){
							$(this).css({x:0, y:0, opacity:0})
							.transition({x:-90, y:10, opacity:1, duration:300, delay:300});
						}else{
							$(this).css({x:0, y:0, opacity:0})
							.transition({x:0, y:0, opacity:1, duration:300});
						}
					});
					this.open = true;
				}

				//모바일 우측하단 플로팅 버튼 클로즈
				function floatingClose() {
					floatingMenus.each(function(i) {
						
						$(this).css({"z-index":-1});
						if( i == 0 ){
							$(this).transition({x:0, y:0, opacity:0, duration:300, delay:300});
						}else if(i==1){
							$(this).transition({x:0, y:0, opacity:0, duration:300, delay:200});
						}else if(i==2){
							$(this).transition({x:0, y:0, opacity:0, duration:300, delay:100});
						}else{
							$(this).transition({x:0, y:0, opacity:0, duration:300});
						}
					});
					this.open = false;
				}

			}
			
			//=================================== family site ==========================================
			
			function familySite(){
				
				var familySite = $(".cjWebPolicy");
				var btn = $(".cjWebPolicy #trigger");
				$('.family').append(familySite[0]);
				
				btn.bind("click",function(e){
					$(this).toggleClass('on')
				});
			}
			
			//=================================== top button ==========================================
			function topBtn(){
				var tBtn = $(".topbt");
				
				this.fixed = function(){
					if(tBtn.hasClass('posa'))tBtn.removeClass('posa');
				}
				
				this.absolute = function(){
					if(!tBtn.hasClass('posa'))tBtn.addClass('posa');
				}
				
				tBtn.bind("click",function(e){
					e.preventDefault();
					$("html, body").animate({"scrollTop": 0}, 500);
				});
			}
			
			
			//=================================== 실적 팝업 ==========================================
			function popupBuilding(){
				var popup = $(".full-popup"), 
					pages, pageWrap, pageImg, closeBtn, arrBtns, nextBtn, prevBtn, btns,
					touchX, endTouchX, isMove=false, isShow=false,
					total = 0,
					current = 0;
				
				this.show = function(){
					isShow = true;
					popup.css({'display':'block','position':'fixed'});
					init();
				}
				
				this.hide = function(){
					isShow = false;
					popup.css('display','none');
				}
				
				this.init = function(){
					isShow = true;
					init();
				}

				function init(){
					pop = $(".full-popup");
					pages = $(".full-popup .img-wrap .img");
					pageImg = $(".full-popup .img-wrap .img img");
					pageWrap = $(".full-popup .img-wrap");
					closeBtn = $(".full-popup #layerClose");
					arrBtns = $(".full-popup .arr a");
					nextBtn = $(".full-popup .arr .next");
					prevBtn = $(".full-popup .arr .prev");
					btns = $(".full-popup .bts a");
					
					pageImg.hide();
					
					total = pages.length
					current = 0;
					
					if( total > 1)pages.css("left","-200%");
					
					addCloseEvent();

					// 팝업 호출시 포커스 보내기 추가
					pop.attr('tabindex', 0);
					pop.focus();
					
					pop.imagesLoaded().done(function(instance) {
						//console.log('all images successfully loaded');
						setLayout();
						addResizeEvent();
						$(window).resize();
						if( total > 1){
							addEvent();
							setBtn();
						}else{
							prevBtn.css("display","none");
							nextBtn.css("display","none");
						}
						goPage();
					});
				}
				
				function addResizeEvent(){
					
					$(window).resize(function(e){
						if( isShow == true ){
							var wWidth = window.innerWidth;
							var currPage = pageImg.eq(current);
							
							var conWidth = pages.outerWidth();
							var conHeight = pages.outerHeight();
							var conRotaito = conWidth/conHeight;
							
							currPage.removeClass("landscape");
							currPage.removeClass("portrait");
							currPage.removeAttr("style");
							
							if( conRotaito >= 1 ){
								if( currPage.data("ratio") > conRotaito){
									currPage.addClass("portrait");
									currPage.css("margin-top",("-"+currPage.outerHeight()/2+ "px"));
								}else{
									currPage.addClass("landscape");
									currPage.removeAttr("style");
								}
							}else{
								if( currPage.data("ratio") < conRotaito){
									currPage.addClass("landscape");
									currPage.removeAttr("style");
								}else{
									currPage.addClass("portrait");
									currPage.css("margin-top",("-"+currPage.outerHeight()/2+ "px"));
								}
							}
						}
					});
				}
				
				function addCloseEvent(){
					closeBtn.bind("click", function(e){
						e.preventDefault();
						popup.css('display', 'none');
						$("body").removeAttr("style");
						isShow = false;
					});
				}
				
				function addEvent(){
					
					removeEvent();
					
					addCloseEvent();
					
					btns.bind("click", function(e){
						e.preventDefault();
						var idx = btns.index($(this));
						
						current = idx;
						setBtn();
						goPage();
					});
					
					arrBtns.bind("click",function(e){
						e.preventDefault();
						var direction;
						
						if($(this).hasClass('prev')){
							direction = -1;
						}else{
							direction = 1;
						}
						current += direction;
						setBtn();
						goPage();
					});
					
					pageWrap.bind("touchstart", function(e){
						e.preventDefault();
						touchX = e.originalEvent.touches[0].clientX;
					});
					
					pageWrap.bind("touchmove", function(e){
						e.preventDefault();
						isMove = true;
						endTouchX = e.originalEvent.touches[0].clientX;
					});
					
					pageWrap.bind("touchend", function(e){
						e.preventDefault();
						var direction;
						if(  isMove == true ){
							if( touchX > endTouchX){
								direction = 1;
							}else{
								direction = -1;
							}
							current += direction;
							
							setBtn();
							goPage();
							
							isMove = false;
						}
					});
				}
				
				function removeEvent(){
					closeBtn.unbind("click");
					btns.unbind("click");
					arrBtns.unbind("click");
					pageWrap.unbind("touchstart");
					pageWrap.unbind("touchmove");
					pageWrap.bind("touchend");
				}
				
				function setLayout(){
					
					if( isShow == true ){
						$("body").css({"overflow":"hidden"});
					}
					
					pageImg.each(function(e){
						
						var imgWidth = $(this).outerWidth();
						var imgHeight = $(this).outerHeight();
						
						$(this).data("ratio",imgWidth / imgHeight);
					});
				}
				
				function setBtn(){
					if( current<=0 ){
						current = 0;
						prevBtn.css("display","none");
						nextBtn.css("display","block");
					}else if( current >= total-1){
						current = total-1;
						prevBtn.css("display","block");
						nextBtn.css("display","none");
					}else{
						nextBtn.css("display","block");
						prevBtn.css("display","block");
					}
				}
				
				function goPage(){
					
					
					pages.each(function(i){
						
						
						if($(this).hasClass('show')){
							$(this).addClass('prevpage');
						}else{
							$(this).removeClass('prevpage');
						}
						
						if( i == current ){
							$(this).addClass('show');
						}else{
							$(this).removeClass('show');
						}
						
					});
					
					btns.each(function(i){
						if( current == i ){
							$(this).addClass("on");
						}else{
							$(this).removeClass("on");
						}
					});
					
					$(window).resize();
				}
			}
			
		});

		$(window).load(function() {
			/* Act on the event */
			/*
			* 주소창의 파라미터에 searGubun이 있으면 리스트보기 이미지 보기 버튼의 위치로 스크롤 이동
			*
			*/
			function getUrlVars()
			{
			    /*
			    var vars = [], hash;
			    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
			    for(var i = 0; i < hashes.length; i++)
			    {
			        hash = hashes[i].split('=');
			        vars.push(hash[0]);
			        vars[hash[0]] = hash[1];
			    }
			    return vars;
			    */
			    var loc = window.location.href;
			    var result1 = new RegExp("searGubun");
                var result2 = new RegExp("/business/building");
			    var vars = false;

			    if( result1.test(loc) == true && result2.test(loc) == false){
				vars = true;
			    }
			    return vars;
			}
			/*
			if( getUrlVars().indexOf("searGubun") != -1 ){
				var targetPos;
				if( window.innerWidth < 768 ){
					targetPos = $(".sorting").offset().top - 50;
				}else{
					targetPos = $(".sorting").offset().top - 70;
				}
				$(window).scrollTop(targetPos);
			}
			*/
			if(getUrlVars()){
				var targetPos;
				if( window.innerWidth < 768 ){
					targetPos = $(".sorting").offset().top - 100;
				}else{
					targetPos = $(".sorting").offset().top - 70;
				}
				$(window).scrollTop(targetPos);
			}
		});
	}());
;