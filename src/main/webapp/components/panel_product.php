<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet" href="resources/css/pannel-product.css" />
<!--Biển quảng cáo đầu trang-->
<div class="panel-baner"> 
    <div  class="banner-container" >
        <div class="container-mini">
            <div uk-slideshow="animation: face; autoplay: true; autoplay-interval: 5000">
                <div class="  uk-position-relative uk-visible-toggle uk-light" tabindex="-1">
                    <div class="uk-slideshow-items">
                        <div>
                            <img src="resources/images/banner-1.jpg" alt="" uk-cover>
                        </div>
                        <div>
                            <img src="resources/images/banner-1.jpg" alt="" uk-cover>
                        </div>
                        <div>
                            <img src="resources/images/banner-1.jpg" alt="" uk-cover>
                        </div>
                    </div>
                    <a class="uk-position-center-left uk-position-small uk-hidden-hover" href uk-slidenav-previous uk-slideshow-item="previous"></a>
                    <a class="uk-position-center-right uk-position-small uk-hidden-hover" href uk-slidenav-next uk-slideshow-item="next"></a>
                    <ul class="uk-slideshow-nav uk-dotnav uk-flex-center uk-position-bottom uk-position-medium"></ul>
                    <ul>
                        <li class="uk-position-bottom"></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Các cam kết :vận chuyển ,trả hàng , thanh toán , hỗ trợ  -->
<div class="panel-commit">
    <div class="uk-child-width-1-4" uk-grid>
        <div class="commit">        
            <i class="fas fa-truck"></i>
            <p class="icon-text">Miễn phí vận chuyển <br> cho đơn hàng trên 500.000đ</p>
        </div>
        <div class="commit">
            <i class="fas fa-sync"></i>
            <p class="icon-text">Đổi trả dễ dàng trong 7 ngày</p>
        </div>
        <div class="commit">
            <i class="fab fa-cc-amazon-pay"></i>
            <p class="icon-text">Thanh toán an toàn bảo mật</p>    
        </div>
        <div class="commit">
            <i class="fab fa-napster"></i>
            <p class="icon-text">Hỗ trợ khách hàng 24/7</p>
        </div>
    </div>

</div>
<div class="t28" > Các danh mục hànng đầu </div>

<div class="panel-Categories">
    <div class="uk-child-width-1-3@m uk-child-width-1-2@s" uk-grid>
        <div class="Categories">
            <div class="Categories-image">
                <img src="resources/images/hoa-cuoi.jpg" alt="">
            </div>
            <ul class="uk-text-middle">
                <b>Hoa cưới</b>
                <li><a href="">Cổng hoa</a></li>
                <li><a href="">Hoa sân khấu</a></li>
                <li><a href="">Hoa bàn tiệc</a></li>
                <li><a href="">Hoa cầm tay cô dâu</a></li>
            </ul>
        </div>
        <div class="Categories">
            <div class="Categories-image">
                <img src="resources/images/hoa-tang.jpg" alt="">            
            </div>
            <ul class="uk-text-middle">
                <b>Hoa quà tặng</b>
                <li><a href="">Hoa Hồng</a></li>
                <li><a href="">Hoa cẩm tú cầu</a></li>
                <li><a href="">Hoa lily</a></li>
            </ul>
        </div>
        <div class="Categories">
            <div class="Categories-image">
                <img src="resources/images/hoa-trangtri.jpg" alt="">
            </div>
            <ul class="uk-text-middle">
                <b>Hoa trang trí</b>
                <li><a href="">Hoa lan</a></li>
                <li><a href="">Hoa huệ</a></li>
                <li><a href="">Hoa cúc</a></li>
            </ul>
        </div>
    </div>
</div>
   <!--  quảng cáo thứ 2(2 sản phẩm nổi bật nhất) -->
<div class="panel-baner2">
        <div class="uk-child-width-1-2@m uk-child-width-1-2" uk-grid>
        <div class="banner2-image" >
            <div class="uk-inline-clip uk-transition-toggle" tabindex="0">
                <img src="resources/images/banner-4.jpg"  alt="">
                <img class="uk-transition-scale-up uk-position-cover" src="resources/images/banner-2.jpg" alt="">
            </div>
        </div>
        <div class="banner2-image">
            <div class="uk-inline-clip uk-transition-toggle" tabindex="0">
                <img src="resources/images/banner-4.jpg"alt="">
                <img class="uk-transition-scale-up uk-position-cover" src="resources/images/banner-2.jpg" alt="">
            </div>
        </div>
    </div>
</div>
<div class="panel-product">
    <div class="uk-section uk-section-muted">
        <!-- Hoa cưới -->
        <div class="pannel-product-container">
    <h3>Hoa event</h3>
    <div class="uk-grid-match uk-child-width-1-5@m uk-child-width-1-3@s uk-child-width-1-2@xs" uk-grid>
        <?php for ($i = 1; $i <= 4; $i++) { ?>
        <div class="uk-card uk-card-default">
            <div class="uk-card-body">
                <div class="product-image"> 
                    <a href="#">
                        <img src="resources/images/hoahong.jpg" alt="Hoahong Image">
                    </a>
                </div>
                <div class="product-review">
                    <?php for ($j = 0; $j < 5; $j++) { ?>
                        <span class="uk-icon" uk-icon="star"></span>
                    <?php } ?>
                </div>
                <div class="product-name">
                    <a href="#" title="OPPO Product <?= $i ?>">
                    <h2>Hoa <?= $i ?></h2>
                    </a>
                </div>
                <div class="product-price">
                    <div class="price-sale">500.000 đ</div>
                    <div class="price-main black" style="text-decoration: line-through;">900.000 đ</div>
                </div>
                <div class="product-sold color-2">
                    <progress value="30" max="100"></progress>
                    <div class="status">
                        <span>Còn hàng</span>
                        <span>Đã bán: <span class="special">3</span></span>
                    </div>
                </div>
                <div class="product-cart">
                    <a href="#" title="Thêm vào giỏ hàng">
                    <span class="uk-icon" uk-icon="cart"></span>
                    </a>
                </div>
            </div>
        </div>
        <?php } ?>
    </div>
</div>


<!-- Sản phẩm iPhone -->
<div class="pannel-product-container">
    <h3>Hoa cưới</h3>
    <div class="uk-grid-match uk-child-width-1-5@m uk-child-width-1-3@s uk-child-width-1-2@xs" uk-grid>
        <!-- Sản phẩm iPhone 1-5 -->
        <?php for ($i = 1; $i <= 5; $i++) { ?>
        <div class="uk-card uk-card-default">
            <div class="uk-card-body">
                <div class="product-image"> 
                    <a href="#">
                    <img src="resources/images/hoahong.jpg" alt="Hoahong Image">
                    </a>
                </div>
                <div class="product-review">
                    <?php for ($j = 0; $j < 5; $j++) { ?>
                        <span class="uk-icon" uk-icon="star"></span>
                    <?php } ?>
                </div>
                <div class="product-name">
                    <a href="#" title="iPhone Product <?= $i ?>">
                        <h2>Hoa <?= $i ?></h2>
                    </a>
                </div>
                <div class="product-price">
                    <div class="price-sale">15.000.000 đ</div>
                    <div class="price-main black" style="text-decoration: line-through;">18.000.000 đ</div>
                </div>
                <div class="product-sold color-2">
                    <progress value="40" max="100"></progress>
                    <div class="status">
                        <span>Còn hàng</span>
                        <span>Đã bán: <span class="special">5</span></span>
                    </div>
                </div>
                <div class="product-cart">
                    <a href="#" title="Thêm vào giỏ hàng">
                    <span class="uk-icon" uk-icon="cart"></span>
                    </a>
                </div>
            </div>
        </div>
        <?php } ?>
    </div>
</div>

<!-- Sản phẩm Redmi -->
<div class="pannel-product-container">
    <h3>Hoa hội nghị</h3>
    <div class="uk-grid-match uk-child-width-1-5@m uk-child-width-1-3@s uk-child-width-1-2@xs" uk-grid>
        <!-- Sản phẩm Redmi 1-3 -->
        <?php for ($i = 1; $i <= 3; $i++) { ?>
        <div class="uk-card uk-card-default">
            <div class="uk-card-body">
                <div class="product-image"> 
                    <a href="#">
                        <img src="<img src="resources/images/hoahong.jpg" alt="Hoahong images">
                    </a>
                </div>
                <div class="product-review">
                    <?php for ($j = 0; $j < 5; $j++) { ?>
                        <span class="uk-icon" uk-icon="star"></span>
                    <?php } ?>
                </div>
                <div class="product-name">
                    <a href="#" title="Redmi Product <?= $i ?>">
                        <h2>Hoa <?= $i ?></h2>
                    </a>
                </div>
                <div class="product-price">
                    <div class="price-sale">4.000.000 đ</div>
                    <div class="price-main black" style="text-decoration: line-through;">6.000.000 đ</div>
                </div>
                <div class="product-sold color-2">
                    <progress value="25" max="100"></progress>
                    <div class="status">
                        <span>Còn hàng</span>
                        <span>Đã bán: <span class="special">2</span></span>
                    </div>
                </div>
                <div class="product-cart">
                    <a href="#" title="Thêm vào giỏ hàng">
                    <span class="uk-icon" uk-icon="cart"></span>
                    </a>
                </div>
            </div>
        </div>
        <?php } ?>
    </div>
</div>
      
    </div>
</div>