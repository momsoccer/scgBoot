( function() {
		$(document).ready(function() {
			/**
			 *
			 * main관련 비쥬얼,페이지 및 팝업 이벤트
			 *
			 **/
			//메인 비주얼
			var mVisual = new mainVisual();
			//
			var myPhotoWall = new photoWall();
			//visual
			var visual = m_visual();

			//레이아웃 이벤트 관련
			var myWheel = new wheelEvent();
			var myLayout = new layout();
			var myScroll = new scrollEvent();
			var myResize = new resizeEvent();

			mVisual.goPage(0);
			$.fn.photoWall = myPhotoWall;

			//===============================================================================================================================
			//======================================================== mobileCheck ==========================================================
			//===============================================================================================================================
			function mobileCheck() {
				var md = new MobileDetect(window.navigator.userAgent);
				var dv;
				if (md.phone() != null) {
					dv = "phone";
				} else if (md.tablet() != null) {
					dv = "tablet";
				} else {
					dv = "pc";
				}
				return dv;
			}

			//===============================================================================================================================
			//======================================================== scrollEvent ==========================================================
			//===============================================================================================================================

			function scrollEvent() {
				var scrollTop,
					transfromString,
					wHeight,
					mode,
					parallaxMode,
					delta,
					isVisual = true,
					isParallax = true,
					scrollAnimate = false,
					visual2 = $("section:eq(1)"),
					visual3 = $("section:eq(2)");

				this.addEvent = function(type) {

					if (type == "visual")
						isVisual = true;
					if (type == "parallax")
						isParallax = true;
				}

				this.removeEvent = function(type) {

					if (type == "visual")
						isVisual = false;
					if (type == "parallax")
						isParallax = false;
				}

				this.update = function() {
					chkScroll();
				}

				$(window).scroll(function() {
					//
					chkScroll();
				});

				function chkScroll() {
					scrollTop = $(window).scrollTop();
					wHeight = window.innerHeight;
					//상단 비주얼 모션컨트롤 관련
					if (scrollTop == 0) {
						if (mode != "top") {
							//스크롤이 0일때
							if (isVisual)
								mVisual.motionPlay();
							mode = "top";
						}
					}
					
					if (scrollTop > 0) {
						if (mode != "mid") {

							mVisual.motionStop();
							mode = "mid";
						}
					}
					//비주얼영역 딤드처리 및 텍스트 및 오브젝트 투명도 관련 
					if (scrollTop < visual2.offset().top) {
						if (isParallax) {
							mVisual.objOpacity(1 - (scrollTop / visual2.offset().top) * 1.5);
							mVisual.dimmedOpacity((scrollTop / visual2.offset().top) * 0.7);
						}
					} else {
						if (isParallax) {
							mVisual.objOpacity(0);
							mVisual.dimmedOpacity(0.7);
							parallaxMode = false;
						}

					}
					//중간 실적 포토월 부분 페럴럭스 모션
					if (isParallax) {
						if (scrollTop < visual3.offset().top) {
							myPhotoWall.parallex(scrollTop);
						} else {
							myPhotoWall.parallex(visual3.offset().top);
						}
					}
				}

			}

			//===============================================================================================================================
			//======================================================== resizeEvent ==========================================================
			//===============================================================================================================================
			function resizeEvent() {
				var wWidth,
					wHeight,
					mode,
					pcMode;

				chkWidth();

				$(window).resize(function(e) {
					//visual 레이아웃 체인지
					chkWidth();
				});

				function chkWidth() {

					wWidth = window.innerWidth;
					if (wWidth < 768) {
						//mobile
						if (mode != "mobile") {
							//100% 레이아웃 제거
							myLayout.removeLayout();
							//모션 스탑
							mVisual.setMotionType("mobile");
							mVisual.visualUnfixed();
							mVisual.objOpacity(1);
							mVisual.dimmedOpacity(0);
							mVisual.stopVideo();

							myPhotoWall.resetParallex();
							//PC일때 bg생성 - 768~1280사이에서 제거한 이미지 복구
							if( mobileCheck() == "pc")mVisual.addImage();
							
							//스크롤 관련 이벤트 제거 - visual play, parallax
							myScroll.removeEvent("parallax");
							myScroll.update();
							mode = "mobile";

							myPhotoWall.visualMode("mobile");
						}
						
						$('.hidden-image').remove();
					}

					if (767 <= wWidth) {
						myLayout.changeLayout();
						if (pcMode != true) {
							vod = $("#container section:eq(0) video");
							
							mVisual.setMotionType("pc");
							mVisual.visualFixed();
							//mVisual.playVideo();
							
							// 페이지 로딩시 동영상이 좀 늦게 나오도록 처리
							$("#container .img img:first").show();
							vod.filter(':first').hide();
							vod.filter(':first')[0].pause();
							
							vod.filter(':first')[0].onloadedmetadata = function() {
								setTimeout(function(){
									vod.filter(':first').show();
									$("#container .img img:first").hide();
									vod.filter(':first')[0].play();
									$('.hidden-image').remove();
								}, 1000);
							};
							
							//타블렛일때 영상 제거
							if( mobileCheck() != "pc")mVisual.removeVideo();

							myScroll.addEvent("parallax");
							myScroll.update();
							pcMode = true;
						}
					} else {
						pcMode = false;
					}

					if (768 <= wWidth && wWidth < 1280) {
						//pc1
						if (mode != "mid") {
							myPhotoWall.visualMode("mid");
							//PC일때 bg제거-video가 보이기 때문
							if( mobileCheck() == "pc")mVisual.removeImage();
							mode = "mid";
						}
					}

					if (wWidth > 1280) {
						//pc2
						if (mode != "big") {
							myPhotoWall.visualMode("big");
							mode = "big";
						}
					}
				}

			}

			//===============================================================================================================================
			//======================================================== wheelEvent ===========================================================
			//===============================================================================================================================
			
			//비주얼 부분 스크롤 관련
			function wheelEvent() {

				var delta,
					isComplete = false;

				addEvent();

				this.delta = function() {
					return delta;
				}

				this.addEvent = function() {
					enableScroll();
					addEvent();
				}

				this.removeEvent = function() {
					disableScroll();
				}
				
				function addEvent() {
					$("html, body").bind('mousewheel DOMMouseScroll', scrollUpdate);
				}

				function removeEvent() {
					$("html, body").off('mousewheel DOMMouseScroll', scrollUpdate);
				}

				function scrollUpdate(e) {
					
					var E = e.originalEvent;
					delta = 0;
					if (E.detail) {
						delta = E.detail * -40;
					} else {
						delta = E.wheelDelta;
					};

					var scrollTop = $(window).scrollTop();
					var wHeight = window.innerHeight;
					var targetPos = scrollTop - delta;
					
					if( wHeight <= 700)wHeight = 700;
					
					if(0<targetPos && targetPos < wHeight){
						disableScroll();
						removeEvent();
						isComplete = false;
						
						if (delta > 0) {
							targetPos = 0;
						} else if (delta < 0) {
							targetPos = wHeight;
						}
						
						$("html, body").stop().animate({
							"scrollTop" : targetPos
						}, 400, function() {
							if(isComplete == false){
								addEvent();
								enableScroll();
								isComplete = true;
							}
						});
					}
				}

				var keys = {37 : 1,	38 : 1,	39 : 1,	40 : 1};

				function preventDefault(e) {
					e = e || window.event;
					if (e.preventDefault)
						e.preventDefault();
					e.returnValue = false;
				}

				function preventDefaultForScrollKeys(e) {
					if (keys[e.keyCode]) {
						preventDefault(e);
						return false;
					}
				}

				function disableScroll() {
					if (window.addEventListener)// older FF
						window.addEventListener('DOMMouseScroll', preventDefault, false);
					window.onwheel = preventDefault;// modern standard
					window.onmousewheel = document.onmousewheel = preventDefault;// older browsers, IE
					window.ontouchmove = preventDefault;// mobile
					document.onkeydown = preventDefaultForScrollKeys;
				}

				function enableScroll() {
					if (window.removeEventListener)
						window.removeEventListener('DOMMouseScroll', preventDefault, false);
					window.onmousewheel = document.onmousewheel = null;
					window.onwheel = null;
					window.ontouchmove = null;
					document.onkeydown = null;
				}

			}

			//===============================================================================================================================
			//======================================================== layout ===============================================================
			//===============================================================================================================================
			function layout() {
				//레이아웃 관련
				var visuals = $("#container .main-section, #container .main-section .roll, #container .main-section .roll-in, #container .bg"),
					visualImageCon = $("#container .main-section .roll .img"),
					visualImage = $("#container .main-section .roll .img img"),
					visualVideo = $("#container .main-section .roll .img video"),
					section = $("section:eq(0)"),
				//변수
					_stageWidth,
					_stageHeight,
					_imageWidth,
					_imageHeight,
					IMAGE_WIDTH = 1280,
					IMAGE_HEIGHT = 720;

				this.changeLayout = function() {
					layoutUpdate();
				}

				this.removeLayout = function() {
					removeLayout();
				}
				defaultSet();

				function defaultSet() {
					section.css("z-index", "0");
				}

				function layoutUpdate() {
					//비율별 이미지 사이즈 제어
					_stageHeight = window.innerHeight;
					_stageWidth = $('.main-section').eq(0).outerWidth();//window.innerWidth;
					_imageWidth = $(visualImage[0]).width();
					_imageHeight = $(visualImage[0]).height();

					if (_stageHeight < 700)
						_stageHeight = 700;

					//높이제어(세로기준으로 가로를 맞춤)
					if (_stageHeight < _imageHeight || _stageHeight > _imageHeight) {//플랫폼이 이미지의세로보다 작거나 크면
						_imageHeight = _stageHeight;//이미지의 세로를 플랫폼으로 맞추고
						_imageWidth = _stageHeight * IMAGE_WIDTH / IMAGE_HEIGHT;//세로에따른 비율계산
					}

					//가로제어(가로기준으로 세로를 맞춤)
					if (_stageWidth > _imageWidth) {//플랫폼이 이미지의가로보다 크면
						_imageWidth = _stageWidth;//이미지의 가로를 플랫폼으로 맞추고
						_imageHeight = _stageWidth * IMAGE_HEIGHT / IMAGE_WIDTH;//가로에따른 비율계산
					}

					visualImageCon.css("margin-left", -_imageWidth / 2);
					visualImage.css({"width" : _imageWidth, "height" : _imageHeight});
					visualVideo.css({"width" : _imageWidth, "height" : _imageHeight});
					visuals.height(_stageHeight);
				}

				function removeLayout() {
					visuals.css("height", "");
					visualImageCon.css("margin-left", "")
					visualImage.removeAttr("style");
				}

			}

			//===============================================================================================================================
			//======================================================== main visual ==========================================================
			//===============================================================================================================================
			function mainVisual() {

				var list = $("#container section:eq(0) .roll-in"),
					listCon = $("#container section:eq(0) .roll"),
					btns = $("#container section:eq(0) .bts .bt1 a"),
					btnsCon = $("#container section:eq(0) .bts"),
					playStopBtn = $("#container section:eq(0) .bts .bt2 a"),
					vod = $("#container section:eq(0) video"),
					images = $("#container section:eq(0) .img"),
					visualBG = $("section:eq(0) .roll"),
					visualBts = $("section:eq(0) .bts"),
					dimmed = $(".dim");
					
				//동적 변수
				var pageNum = 0,
					total = 3,
					current = 0,
					playMode = "pc",
					pageTimer = [5000, 5000, 5000],
					state,
					prev,
					playInterval, 
					touchX,
					endTouchX,
					isMove;

				this.motionPlay = function() {
					play();
				}

				this.motionStop = function() {
					stop();
					prev = -1;
				}

				this.nextPage = function() {
					nextPage();
				}

				this.setMotionType = function(type) {
					playMode = type;
				}

				this.objOpacity = function(num) {
					objOpacity(num);
				}

				this.dimmedOpacity = function(num) {
					dimmedOpacity(num);
				}

				this.goPage = function(num) {
					goPage(num);
				}

				this.playVideo = function() {
					playVideo();
				}

				this.stopVideo = function() {
					stopVideo();
				}

				this.visualFixed = function() {
					visualFixed();
				}

				this.visualUnfixed = function() {
					visualUnfixed();
				}
				
				this.removeVideo = function(){
					vod.css("display","none");
				}
				
				this.addImage = function(){
					images.removeClass("bgno");
				}
				
				this.removeImage = function(){
					//images.addClass("bgno");
					images.each(function(i){
						if($(this).find("video").length == 1)$(this).addClass("bgno");
					});
				}
				
				init();

				function init() {
					addEvent();
					dimmed.css("z-index", "3");
					list.addClass('hidden');
				}

				function addEvent() {
					//버튼 이벤트
					btns.bind("mouseover", function(e) {
						//stop();
					});

					btns.bind("mouseout", function(e) {
						//play();
					});

					btns.bind("click", function(e) {
						e.preventDefault();
						pageNum = btns.index(this);
						goPage(pageNum);
						stop();
						play();

						playStopBtn.removeClass('on');
						playStopBtn.filter('.play').addClass('on');
						state = 'play';
					});
					
					playStopBtn.bind("click", function(e) {
						e.preventDefault();
						
						playStopBtn.removeClass('on');
						$(this).addClass('on');
						
						var idx = playStopBtn.index($(this));
						if( idx == 1 ){
							if (state != "play"){
								nextPage(false);
								play();
							}
						}else{
							//비디오 엄춤
							if( state == "play" ){
								stopVideo();
								stop();
							}
						}
					});

					listCon.bind("touchstart", function(e){
						touchX = e.originalEvent.touches[0].clientX;
						stop();
					});
					
					listCon.bind("touchmove", function(e){
						isMove = true;
						endTouchX = e.originalEvent.touches[0].clientX;
					});
					
					listCon.bind("touchend", function(e){
						if(  isMove == true ){
							if( touchX > endTouchX){
								nextPage(false);
							}else{
								prevPage(false);
							}
							isMove = false;
						}
						play();
					});
				}

				function visualFixed() {
					visualBG.css({"position" : "fixed","top" : 0});
					visualBts.css({"position" : "fixed", "bottom" : "24px"});
				}

				function visualUnfixed() {
					visualBG.css({"position" : "absolute", "top" : 0});
					visualBts.css({"position" : "absolute", "bottom" : "24px"});
				}

				function playVideo() {
					vod.each(function(i){
						var idx = list.index($(this).parent().parent());
						if( pageNum == idx ){
							$(this)[0].play();
						}else{
							$(this)[0].pause();
							if(!isNaN($(this)[0].duration))$(this)[0].currentTime = 0;
						}
					});
				}

				function stopVideo() {
					vod.each(function(i){
						if( !$(this)[0].paused ){
							$(this)[0].pause();
						}
					});
				}
				
				function play() {
					if (state != "play") {
						startInterval();
						state = "play";
					}
				}

				function stop() {
					if (state != "stop") {
						clearTimeout(playInterval);
						state = "stop";
					}
				}
				
				function startInterval() {
					playInterval = setTimeout(nextPage, pageTimer[pageNum]);
				}
				
				function nextPage(isInterval) {
					if (pageNum < total - 1) {
						pageNum++;
					} else {
						pageNum = 0;
					}
					goPage(pageNum);
					if( isInterval != false)startInterval();
				}				

				function prevPage(isInterval){
					if (pageNum > 0) {
						pageNum--;
					} else {
						pageNum = total - 1;
					}
					goPage(pageNum);
					if( isInterval != false)startInterval();
				}

				function goPage(idx) {
					if (idx != prev) {
						playPage(idx);
						setBtn(idx);
						if (prev != undefined)resetPage(prev);
						prev = idx;
					}
				}

				function playPage(idx) {

					//z-index 셋
					setIndex(idx);

					if( list.eq(idx).hasClass('hidden'))list.eq(idx).removeClass('hidden');
					
					if (playMode == "pc") {
						//bg모션
						if (prev != undefined) {
							list.eq(idx).find(".img")
							.css({ scale: 1.1, opacity:0 })
							.transition({scale: 1, opacity:1, duration:700,
								complete:function(){
									if(pageNum != 3){
										playVideo();
									}else{
										stopVideo();
									}
								}
							})
						}else{
							list.eq(idx).find(".img")
							.css({ scale: 1, opacity:0 })
							.transition({scale: 1, opacity:1, duration:700,
								complete:function(){
									if(pageNum != 3){
										playVideo();
									}else{
										stopVideo();
									}
								}
							})
						}
						
						if (idx == 0) {
							//텍스트 모션
							list.eq(idx).find(".tit")
							.css({y:40, opacity:0})
							.transition({y:0, opacity:1, duration:500, easing:'cubic-bezier(.1,.59,.39,.94)'});

							list.eq(idx).find(".txt")
							.css({y:40, opacity:0})
							.transition({y:0, opacity:1, duration:500, easing:'cubic-bezier(.1,.59,.39,.94)', delay:500});

							list.eq(idx).find(".more")
							.css({y:40, opacity:0})
							.transition({y:0, opacity:1, duration:500, easing:'cubic-bezier(.1,.59,.39,.94)', delay:1000});

						} else {
							//텍스트 모션
							list.eq(idx).find(".tit")
							.css({y:40, opacity:0})
							.transition({y:0, opacity:1, duration:500, easing:'cubic-bezier(.1,.59,.39,.94)'});

							list.eq(idx).find(".txt")
							.css({y:40, opacity:0})
							.transition({y:0, opacity:1, duration:500, easing:'cubic-bezier(.1,.59,.39,.94)'});

							list.eq(idx).find(".more")
							.css({y:40, opacity:0})
							.transition({y:0, opacity:1, duration:500, easing:'cubic-bezier(.1,.59,.39,.94)'});
							
							//오브젝트 모션
							list.eq(idx).find("li").eq(0)
							.css({scale:0.1, opacity:0})
							.transition({scale:1, opacity:1, duration:500, easing:'cubic-bezier(.49,.48,.45,1.35)'});

							list.eq(idx).find("li").eq(1)
							.css({scale:0.1, opacity:0})
							.transition({scale:1, opacity:1, duration:500, easing:'cubic-bezier(.49,.48,.45,1.35)', delay:250});

							list.eq(idx).find("li").eq(2)
							.css({scale:0.1, opacity:0})
							.transition({scale:1, opacity:1, duration:500, easing:'cubic-bezier(.49,.48,.45,1.35)', delay:500});
							

						}
					} else {
						if (prev != undefined)list.eq(idx).addClass("mobileVisualAnimate");
					}
					
				}

				function resetPage(idx) {
					if (playMode != "pc") {
						list.eq(idx).removeClass("mobileVisualAnimate");
					};

				}

				function setIndex(idx) {
					
					list.each(function(i) {
						if (i == idx) {
							$(this).css("z-index", "20");
						} else {
							$(this).css("z-index", $(this).css("z-index") - 5);
						}
					});
				}

				function objOpacity(op) {
					list.eq(pageNum).find(".roll-in-txt").css("opacity", op);
					btnsCon.css("opacity", op);
				}

				function dimmedOpacity(op) {
					dimmed.css("opacity", op);
				}

				function setBtn(idx) {
					btns.each(function(i) {
						if (idx == i) {
							$(this).addClass("on");
						} else {
							$(this).removeClass("on");
						}
					});
				}

			}

			//===============================================================================================================================
			//======================================================== photo wall ===========================================================
			//===============================================================================================================================
			function photoWall() {

				var visual = $("section:eq(2)"),
					menus = $("section:eq(2) .building-area>div"),
					menusIn = $("section:eq(2) .building-area>div>div"),
					menuObj = [],
					btns = menus.find("a"),
					visualMode = "big",
					callbackFn,
					ratio = [0.8, 0.3, 1.3, 0.6, 1.5, 0.4, 0.1];

				init();

				this.visualMode = function(mod) {
					visualMode = mod;
				}

				this.parallex = function(st) {
					parallex(st);
				}

				this.resetParallex = function() {
					removeParallex();
				}

				this.callback = function(callback) {
					callbackFn = callback;
				}
				function init() {
					menuSet();
					addMotion();
					addEvent();
				}

				function menuSet() {
					menus.each(function(i) {
						//
						menuObj[i] = {
							menu : $(this),
							con : $(this).find(".bd-in"),
							img : $(this).find(".bd-in").find(".img:eq(0)"),
							imgOver : $(this).find(".bd-in").find(".img:eq(1)"),
							txt : $(this).find(".bd-in").find(".txt")
						};
					});
				}

				function addMotion() {
					for (var i = 0; i < menuObj.length; i++) {
						var obj = menuObj[i];
						for (var j in obj) {
							if (j != "txt")
								obj[j].addClass("motion2");
						}
					}
				}

				function addEvent() {
					btns.bind("click", function(e) {
						e.preventDefault();
					});

					menus.bind("mouseover", function(e) {
						e.preventDefault();
						menuOver(menus.index(this));
					});

					menus.bind("mouseout", function(e) {
						e.preventDefault();
						menuOut(menus.index(this));
					});

					menus.bind("click", function(e) {
						e.preventDefault();
						if( typeof callbackFn == "function" )callbackFn(menus.index(this));

					});

					for (var i = 0; i < menuObj.length; i++) {
						var obj = menuObj[i];
						for (var j in obj) {
							if (j == "txt")
								obj[j].bind("animationend webkitAnimationEnd oanimationend MSAnimationEnd", function() {
									$(this).css("opacity", "1");
								});
						}
					}
				}

				function introMotion() {
					//
				}

				function parllaxMotion() {

				}

				function menuOver(id) {
					var menu = menuObj[id]["menu"],
						imgOver = menuObj[id]["imgOver"],
						txt = menuObj[id]["txt"];

					imgOver.addClass("show");

					if (visualMode == "big") {
						menu.addClass("over");
						if(supportAnimation() == true){
							if (id == 0 || id == 6) {
								txt.addClass("txt-show");
							} else {
								txt.css("opacity", 0);
								txt.addClass("txt-show1");
								//animate
							}
						}else{
							txt.addClass("txt-show");
						}
					} else if (visualMode == "mid") {
						txt.addClass("txt-show");
					}
				}

				function menuOut(id) {
					var menu = menuObj[id]["menu"],
						imgOver = menuObj[id]["imgOver"],
						txt = menuObj[id]["txt"];

					imgOver.removeClass("show");

					if (visualMode == "big") {
						if(supportAnimation() == true){
							menu.removeClass("over");
							if (id == 0 || id == 6) {
								txt.removeClass("txt-show");
							} else {
								txt.removeClass("txt-show1");
								txt.removeAttr("style");
							}
						}else{
							txt.removeClass("txt-show");
						}
					} else if (visualMode == "mid") {
						txt.removeClass("txt-show");
					}
				}

				function parallex(st) {
					for (var i = 0; i < menuObj.length; i++) {
						var offset = menuObj[i]["offsetTop"];
						var menu = menuObj[i]["menu"];
						var targetPos = (visual.offset().top - st ) * ratio[i];
						menu.attr("style", "-webkit-transform:translateY(" + targetPos + "px);" + "-moz-transform:translateY(" + targetPos + "px);" + "-o-transform:translateY(" + targetPos + "px);" + "transform:translateY(" + targetPos + "px);");
					}
				}

				function removeParallex() {
					for (var i = 0; i < menuObj.length; i++) {
						var menu = menuObj[i]["menu"];
						menu.removeAttr("style");
					}
				}

				function supportAnimation(){
					var animation = false,
					animationstring = 'animation',
					keyframeprefix = '',
					domPrefixes = 'Webkit Moz O ms Khtml'.split(' '),
					pfx  = '',
					elm = document.createElement('div');

					if( elm.style.animationName !== undefined ) { animation = true; }    

					if( animation === false ) {
						for( var i = 0; i < domPrefixes.length; i++ ) {
							if( elm.style[ domPrefixes[i] + 'AnimationName' ] !== undefined ) {
								pfx = domPrefixes[ i ];
								animationstring = pfx + 'Animation';
								keyframeprefix = '-' + pfx.toLowerCase() + '-';
								animation = true;
								break;
							}
						}
					}

					return animation;
				}

			}

			//==============================================================================================================================
			//======================================================== main visual ===============================================================
			//==============================================================================================================================
			function m_visual() {

				var visual = $("section[class='m_visual']"),
					visualBt = $("section[class='m_visual'] .visualbt"),
					closeBt = $("section[class='m_visual'] .close-area .close"),
					container,
					requestId = 0,
					alertText,
					timeout,
					// 배열 추가
					imageUrls = ['images/textures/texture.jpg', 'images/textures/texture2.jpg', 'images/textures/texture3.jpg'];

				var camera,
					scene,
					renderer,
					controls,
					updates,
					container,
					mesh;

				var isUserInteracting = false, onMouseDownMouseX = 0, onMouseDownMouseY = 0,
					lon = 95, onMouseDownLon = 0,
					lat = 0, onMouseDownLat = 0,
					phi = 0, theta = 0;

				//
				addEvent();

				function addEvent() {
					visualBt.bind("click", function(e) {
						e.preventDefault();
						
						var idx = $(this).attr('class').split('visualbg0')[1] - 1;
						makeVr(imageUrls[idx], idx);  // 클릭시 배열에서 이미지 주소를 얻어 처리하도록 변경
					});					
					
					visualBt.hover(function(){
						wWidth = window.innerWidth;
						if (767 <= wWidth) {
							var txt = $(this).find('span:not(.visualover)');
							var visualover = $(this).find('span.visualover');
							var cjEnm = $(this).find('.v_more');
							
							txt.stop().animate({opacity:0},{duration:300, queue:false});
							visualover.stop().animate({opacity:1},{duration:300, queue:false});
							cjEnm.stop().animate({opacity:1},{duration:300, queue:false});
						}
					}, function(){
						wWidth = window.innerWidth;
						if (767 <= wWidth) {
							var txt = $(this).find('span:not(.visualover)');
							var visualover = $(this).find('span.visualover');
							var cjEnm = $(this).find('.v_more');
							
							txt.stop().animate({opacity:1},{duration:300, queue:false});
							visualover.stop().animate({opacity:0},{duration:300, queue:false});
							cjEnm.stop().animate({opacity:0},{duration:300, queue:false});
						}
					});

					closeBt.bind("click", function(e) {
						e.preventDefault();
						hideCanvas(stopAnimate);
					});

					addEventListener("ThreejsNotSupport", function(){alert("notsuport!")});
				}

			
			}

		});
	}());
;