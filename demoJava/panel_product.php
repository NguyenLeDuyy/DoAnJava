<style>
    /*quang cao */
    .panel-banner{ 
        padding-top: 1rem;
        padding-bottom: 1rem;
        background-color:hotpink;
    }
    .container{  
        padding: 10px;
        background-color:wheat;
        
    }
    .container-mini{
        background-color:greenyellow;        
        padding:10px; 
        margin-left: 50px; 
        margin-right: 50px;
    }
    .uk-slideshow-items {
    width: 600px; /* Chiều rộng mong muốn */
    height: 500px; /* Chiều cao mong muốn */
    max-width: 100%; /* Đảm bảo slideshow không vượt quá kích thước màn hình */
}
.uk-slideshow-items img {
    width: 100%;
    height: 100%;
    object-fit: cover; /* Đảm bảo ảnh phủ đầy khung mà không bị méo */
}
/*sản phâm */
.panel-product{
    background-color:maroon;
}
.uk-section{
    /*background-color:hotpink;*/
    padding-top: 2px;
}
.uk-container{
    margin-top:10px;
}
.uk-container h3, .price-sale {
    font-family:'Nunito', sans-serif;
    font-size: 28px;
    font-weight: 700;
}
/* .uk-card {
    background-color: khaki;
} */
.uk-card-body{
    background-color: rgb(251, 245, 245);
    padding: 2px;
    text-align: center;
}
.product-review{
    color:#B22222;
    margin: 4px 0 8px 0;
}
.product-name h2{
    font-family: "Nunito", sans-serif;
    font-size: 20px;
    font-weight: 600;
    margin-bottom:4px ;
}
.product-price {color: #DC143C; }
.price-sale{font-size :22px;}
.black{color:black;}
.color-2{color:#800080;}
.status{display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 5px 10px;
    font-size: 10px;}

</style>
<div class="panel-baner"> 
    <div  class="container" >
        <div class="container-mini">
            <div uk-slideshow="animation: face; autoplay: true; autoplay-interval: 5000">
                <div class="  uk-position-relative uk-visible-toggle uk-light" tabindex="-1">
                    <div class="uk-slideshow-items">
                        <div>
                            <img src="images/anh1.jpg" alt="" uk-cover>
                        </div>
                        <div>
                            <img src="images/anh2.jpg" alt="" uk-cover>
                        </div>
                        <div>
                            <img src="images/anh3.jpg" alt="" uk-cover>
                        </div>
                    </div>
                    <a class="uk-position-center-left uk-position-small uk-hidden-hover" href uk-slidenav-previous uk-slideshow-item="previous"></a>
                    <a class="uk-position-center-right uk-position-small uk-hidden-hover" href uk-slidenav-next uk-slideshow-item="next"></a>
                    <ul class="uk-slideshow-nav uk-dotnav uk-flex-center uk-position-bottom uk-position-medium"></ul>
                    <ul>
                        <li class="uk-position-bottom">hoa giay</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
 <!-- Phần quảng cáo sản phẩm -->
<div class="panel-product">
    <div class="uk-section uk-section-muted">
        <div class="uk-container">
            <h3>Hoa cưới</h3>
            <div class="uk-grid-match uk-child-width-1-5@m uk-child-width-1-3@s uk-child-width-1-2@xs" uk-grid>
                <!-- Sản phẩm 1 -->
                
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-body">
                            <a href="#" class="image">
                                <img src="https://tse1.mm.bing.net/th?id=OIP.vz3cycLecmyDwRm64tRxUgHaHa&pid=Api&P=0&h=180" alt="Product Image">
                            </a>
                            <div class="product-review">
                            <!-- Đánh giá sản phẩm -->
                            <?php for ($i = 0; $i < 5; $i++) { ?>
                                <span class="uk-icon" uk-icon="star"></span>
                            <?php } ?>
                            </div>
                            <!-- Tiêu đề sản phẩm -->
                             <div class="product-name">
                                <a href="#" title="Tên sản phẩm">
                                    <h2>Sản phẩm 1</h2>
                                </a>
                            </div>
                            <!-- Giá sản phẩm -->
                            <div class="product-price">
                                <div class="price-sale">500.000 đ</div>
                                <div class="price-main black" style="text-decoration: line-through;">900.000 đ</div>
                            </div>
                            <!-- Trạng thái và số lượng đã bán -->
                            <div class="product-sold color-2">
                                <progress  value="30" max="100"></progress>
                                <div class="status ">
                                    <span>Còn hàng</span>
                                    <span>Đã bán: <span class="special">3</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-body">
                            <a href="#" class="image">
                                <img src="https://tse1.mm.bing.net/th?id=OIP.vz3cycLecmyDwRm64tRxUgHaHa&pid=Api&P=0&h=180" alt="Product Image">
                            </a>
                            <div class="product-review">
                            <!-- Đánh giá sản phẩm -->
                            <?php for ($i = 0; $i < 5; $i++) { ?>
                                <span class="uk-icon" uk-icon="star"></span>
                            <?php } ?>
                            </div>
                            <!-- Tiêu đề sản phẩm -->
                             <div class="product-name">
                                <a href="#" title="Tên sản phẩm">
                                    <h2>Sản phẩm 1</h2>
                                </a>
                            </div>
                            <!-- Giá sản phẩm -->
                            <div class="product-price">
                                <div class="price-sale">500.000 đ</div>
                                <div class="price-main black" style="text-decoration: line-through;">900.000 đ</div>
                            </div>
                            <!-- Trạng thái và số lượng đã bán -->
                            <div class="product-sold color-2">
                                <progress  value="30" max="100"></progress>
                                <div class="status ">
                                    <span>Còn hàng</span>
                                    <span>Đã bán: <span class="special">3</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-body">
                            <a href="#" class="image">
                                <img src="https://tse1.mm.bing.net/th?id=OIP.vz3cycLecmyDwRm64tRxUgHaHa&pid=Api&P=0&h=180" alt="Product Image">
                            </a>
                            <div class="product-review">
                            <!-- Đánh giá sản phẩm -->
                            <?php for ($i = 0; $i < 5; $i++) { ?>
                                <span class="uk-icon" uk-icon="star"></span>
                            <?php } ?>
                            </div>
                            <!-- Tiêu đề sản phẩm -->
                             <div class="product-name">
                                <a href="#" title="Tên sản phẩm">
                                    <h2>Sản phẩm 1</h2>
                                </a>
                            </div>
                            <!-- Giá sản phẩm -->
                            <div class="product-price">
                                <div class="price-sale ">500.000 đ</div>
                                <div class="price-main black" style="text-decoration: line-through;">900.000 đ</div>
                            </div>
                            <!-- Trạng thái và số lượng đã bán -->
                            <div class="product-sold color-2">
                                <progress  value="30" max="100"></progress>
                                <div class="status ">
                                    <span>Còn hàng</span>
                                    <span>Đã bán: <span class="special">3</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-body">
                            <a href="#" class="image">
                                <img src="https://tse1.mm.bing.net/th?id=OIP.vz3cycLecmyDwRm64tRxUgHaHa&pid=Api&P=0&h=180" alt="Product Image">
                            </a>
                            <div class="product-review">
                            <!-- Đánh giá sản phẩm -->
                            <?php for ($i = 0; $i < 5; $i++) { ?>
                                <span class="uk-icon" uk-icon="star"></span>
                            <?php } ?>
                            </div>
                            <!-- Tiêu đề sản phẩm -->
                             <div class="product-name">
                                <a href="#" title="Tên sản phẩm">
                                    <h2>Sản phẩm 1</h2>
                                </a>
                            </div>
                            <!-- Giá sản phẩm -->
                            <div class="product-price">
                                <div class="price-sale">500.000 đ</div>
                                <div class="price-main black" style="text-decoration: line-through;">900.000 đ</div>
                            </div>
                            <!-- Trạng thái và số lượng đã bán -->
                            <div class="product-sold color-2">
                                <progress  value="30" max="100"></progress>
                                <div class="status ">
                                    <span>Còn hàng</span>
                                    <span>Đã bán: <span class="special">3</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-body">
                            <a href="#" class="image">
                                <img src="https://tse1.mm.bing.net/th?id=OIP.vz3cycLecmyDwRm64tRxUgHaHa&pid=Api&P=0&h=180" alt="Product Image">
                            </a>
                            <div class="product-review">
                            <!-- Đánh giá sản phẩm -->
                            <?php for ($i = 0; $i < 5; $i++) { ?>
                                <span class="uk-icon" uk-icon="star"></span>
                            <?php } ?>
                            </div>
                            <!-- Tiêu đề sản phẩm -->
                             <div class="product-name">
                                <a href="#" title="Tên sản phẩm">
                                    <h2>Sản phẩm 1</h2>
                                </a>
                            </div>
                            <!-- Giá sản phẩm -->
                            <div class="product-price">
                                <div class="price-sale">500.000 đ</div>
                                <div class="price-main black" style="text-decoration: line-through;">900.000 đ</div>
                            </div>
                            <!-- Trạng thái và số lượng đã bán -->
                            <div class="product-sold color-2">
                                <progress  value="30" max="100"></progress>
                                <div class="status ">
                                    <span>Còn hàng</span>
                                    <span>Đã bán: <span class="special">3</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-body">
                            <a href="#" class="image">
                                <img src="https://tse1.mm.bing.net/th?id=OIP.vz3cycLecmyDwRm64tRxUgHaHa&pid=Api&P=0&h=180" alt="Product Image">
                            </a>
                            <div class="product-review">
                            <!-- Đánh giá sản phẩm -->
                            <?php for ($i = 0; $i < 5; $i++) { ?>
                                <span class="uk-icon" uk-icon="star"></span>
                            <?php } ?>
                            </div>
                            <!-- Tiêu đề sản phẩm -->
                             <div class="product-name">
                                <a href="#" title="Tên sản phẩm">
                                    <h2>Sản phẩm 1</h2>
                                </a>
                            </div>
                            <!-- Giá sản phẩm -->
                            <div class="product-price">
                                <div class="price-sale">500.000 đ</div>
                                <div class="price-main black" style="text-decoration: line-through;">900.000 đ</div>
                            </div>
                            <!-- Trạng thái và số lượng đã bán -->
                            <div class="product-sold color-2">
                                <progress  value="30" max="100"></progress>
                                <div class="status ">
                                    <span>Còn hàng</span>
                                    <span>Đã bán: <span class="special">3</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-body">
                            <a href="#" class="image">
                                <img src="https://tse1.mm.bing.net/th?id=OIP.vz3cycLecmyDwRm64tRxUgHaHa&pid=Api&P=0&h=180" alt="Product Image">
                            </a>
                            <div class="product-review">
                            <!-- Đánh giá sản phẩm -->
                            <?php for ($i = 0; $i < 5; $i++) { ?>
                                <span class="uk-icon" uk-icon="star"></span>
                            <?php } ?>
                            </div>
                            <!-- Tiêu đề sản phẩm -->
                             <div class="product-name">
                                <a href="#" title="Tên sản phẩm">
                                    <h2>Sản phẩm 1</h2>
                                </a>
                            </div>
                            <!-- Giá sản phẩm -->
                            <div class="product-price">
                                <div class="price-sale">500.000 đ</div>
                                <div class="price-main black" style="text-decoration: line-through;">900.000 đ</div>
                            </div>
                            <!-- Trạng thái và số lượng đã bán -->
                            <div class="product-sold color-2">
                                <progress  value="30" max="100"></progress>
                                <div class="status ">
                                    <span>Còn hàng</span>
                                    <span>Đã bán: <span class="special">3</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
               
            </div>
        </div>
        <!-- Phần quảng cáo sản phẩm -->
    <div class="uk-section uk-section-muted">
        <div class="uk-container">
            <h3>Hoa cưới</h3>
            <div class="uk-grid-match uk-child-width-1-5@m uk-child-width-1-3@s uk-child-width-1-2@xs" uk-grid>
                <!-- Sản phẩm 1 -->
                
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-body">
                            <a href="#" class="image">
                                <img src="https://tse1.mm.bing.net/th?id=OIP.vz3cycLecmyDwRm64tRxUgHaHa&pid=Api&P=0&h=180" alt="Product Image">
                            </a>
                            <div class="product-review">
                            <!-- Đánh giá sản phẩm -->
                            <?php for ($i = 0; $i < 5; $i++) { ?>
                                <span class="uk-icon" uk-icon="star"></span>
                            <?php } ?>
                            </div>
                            <!-- Tiêu đề sản phẩm -->
                             <div class="product-name">
                                <a href="#" title="Tên sản phẩm">
                                    <h2>Sản phẩm 1</h2>
                                </a>
                            </div>
                            <!-- Giá sản phẩm -->
                            <div class="product-price">
                                <div class="price-sale">500.000 đ</div>
                                <div class="price-main black" style="text-decoration: line-through;">900.000 đ</div>
                            </div>
                            <!-- Trạng thái và số lượng đã bán -->
                            <div class="product-sold color-2">
                                <progress  value="30" max="100"></progress>
                                <div class="status ">
                                    <span>Còn hàng</span>
                                    <span>Đã bán: <span class="special">3</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-body">
                            <a href="#" class="image">
                                <img src="https://tse1.mm.bing.net/th?id=OIP.vz3cycLecmyDwRm64tRxUgHaHa&pid=Api&P=0&h=180" alt="Product Image">
                            </a>
                            <div class="product-review">
                            <!-- Đánh giá sản phẩm -->
                            <?php for ($i = 0; $i < 5; $i++) { ?>
                                <span class="uk-icon" uk-icon="star"></span>
                            <?php } ?>
                            </div>
                            <!-- Tiêu đề sản phẩm -->
                             <div class="product-name">
                                <a href="#" title="Tên sản phẩm">
                                    <h2>Sản phẩm 1</h2>
                                </a>
                            </div>
                            <!-- Giá sản phẩm -->
                            <div class="product-price">
                                <div class="price-sale">500.000 đ</div>
                                <div class="price-main black" style="text-decoration: line-through;">900.000 đ</div>
                            </div>
                            <!-- Trạng thái và số lượng đã bán -->
                            <div class="product-sold color-2">
                                <progress  value="30" max="100"></progress>
                                <div class="status ">
                                    <span>Còn hàng</span>
                                    <span>Đã bán: <span class="special">3</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-body">
                            <a href="#" class="image">
                                <img src="https://tse1.mm.bing.net/th?id=OIP.vz3cycLecmyDwRm64tRxUgHaHa&pid=Api&P=0&h=180" alt="Product Image">
                            </a>
                            <div class="product-review">
                            <!-- Đánh giá sản phẩm -->
                            <?php for ($i = 0; $i < 5; $i++) { ?>
                                <span class="uk-icon" uk-icon="star"></span>
                            <?php } ?>
                            </div>
                            <!-- Tiêu đề sản phẩm -->
                             <div class="product-name">
                                <a href="#" title="Tên sản phẩm">
                                    <h2>Sản phẩm 1</h2>
                                </a>
                            </div>
                            <!-- Giá sản phẩm -->
                            <div class="product-price">
                                <div class="price-sale ">500.000 đ</div>
                                <div class="price-main black" style="text-decoration: line-through;">900.000 đ</div>
                            </div>
                            <!-- Trạng thái và số lượng đã bán -->
                            <div class="product-sold color-2">
                                <progress  value="30" max="100"></progress>
                                <div class="status ">
                                    <span>Còn hàng</span>
                                    <span>Đã bán: <span class="special">3</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-body">
                            <a href="#" class="image">
                                <img src="https://tse1.mm.bing.net/th?id=OIP.vz3cycLecmyDwRm64tRxUgHaHa&pid=Api&P=0&h=180" alt="Product Image">
                            </a>
                            <div class="product-review">
                            <!-- Đánh giá sản phẩm -->
                            <?php for ($i = 0; $i < 5; $i++) { ?>
                                <span class="uk-icon" uk-icon="star"></span>
                            <?php } ?>
                            </div>
                            <!-- Tiêu đề sản phẩm -->
                             <div class="product-name">
                                <a href="#" title="Tên sản phẩm">
                                    <h2>Sản phẩm 1</h2>
                                </a>
                            </div>
                            <!-- Giá sản phẩm -->
                            <div class="product-price">
                                <div class="price-sale">500.000 đ</div>
                                <div class="price-main black" style="text-decoration: line-through;">900.000 đ</div>
                            </div>
                            <!-- Trạng thái và số lượng đã bán -->
                            <div class="product-sold color-2">
                                <progress  value="30" max="100"></progress>
                                <div class="status ">
                                    <span>Còn hàng</span>
                                    <span>Đã bán: <span class="special">3</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-body">
                            <a href="#" class="image">
                                <img src="https://tse1.mm.bing.net/th?id=OIP.vz3cycLecmyDwRm64tRxUgHaHa&pid=Api&P=0&h=180" alt="Product Image">
                            </a>
                            <div class="product-review">
                            <!-- Đánh giá sản phẩm -->
                            <?php for ($i = 0; $i < 5; $i++) { ?>
                                <span class="uk-icon" uk-icon="star"></span>
                            <?php } ?>
                            </div>
                            <!-- Tiêu đề sản phẩm -->
                             <div class="product-name">
                                <a href="#" title="Tên sản phẩm">
                                    <h2>Sản phẩm 1</h2>
                                </a>
                            </div>
                            <!-- Giá sản phẩm -->
                            <div class="product-price">
                                <div class="price-sale">500.000 đ</div>
                                <div class="price-main black" style="text-decoration: line-through;">900.000 đ</div>
                            </div>
                            <!-- Trạng thái và số lượng đã bán -->
                            <div class="product-sold color-2">
                                <progress  value="30" max="100"></progress>
                                <div class="status ">
                                    <span>Còn hàng</span>
                                    <span>Đã bán: <span class="special">3</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-body">
                            <a href="#" class="image">
                                <img src="https://tse1.mm.bing.net/th?id=OIP.vz3cycLecmyDwRm64tRxUgHaHa&pid=Api&P=0&h=180" alt="Product Image">
                            </a>
                            <div class="product-review">
                            <!-- Đánh giá sản phẩm -->
                            <?php for ($i = 0; $i < 5; $i++) { ?>
                                <span class="uk-icon" uk-icon="star"></span>
                            <?php } ?>
                            </div>
                            <!-- Tiêu đề sản phẩm -->
                             <div class="product-name">
                                <a href="#" title="Tên sản phẩm">
                                    <h2>Sản phẩm 1</h2>
                                </a>
                            </div>
                            <!-- Giá sản phẩm -->
                            <div class="product-price">
                                <div class="price-sale">500.000 đ</div>
                                <div class="price-main black" style="text-decoration: line-through;">900.000 đ</div>
                            </div>
                            <!-- Trạng thái và số lượng đã bán -->
                            <div class="product-sold color-2">
                                <progress  value="30" max="100"></progress>
                                <div class="status ">
                                    <span>Còn hàng</span>
                                    <span>Đã bán: <span class="special">3</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="uk-card uk-card-default">
                        <div class="uk-card-body">
                            <a href="#" class="image">
                                <img src="https://tse1.mm.bing.net/th?id=OIP.vz3cycLecmyDwRm64tRxUgHaHa&pid=Api&P=0&h=180" alt="Product Image">
                            </a>
                            <div class="product-review">
                            <!-- Đánh giá sản phẩm -->
                            <?php for ($i = 0; $i < 5; $i++) { ?>
                                <span class="uk-icon" uk-icon="star"></span>
                            <?php } ?>
                            </div>
                            <!-- Tiêu đề sản phẩm -->
                             <div class="product-name">
                                <a href="#" title="Tên sản phẩm">
                                    <h2>Sản phẩm 1</h2>
                                </a>
                            </div>
                            <!-- Giá sản phẩm -->
                            <div class="product-price">
                                <div class="price-sale">500.000 đ</div>
                                <div class="price-main black" style="text-decoration: line-through;">900.000 đ</div>
                            </div>
                            <!-- Trạng thái và số lượng đã bán -->
                            <div class="product-sold color-2">
                                <progress  value="30" max="100"></progress>
                                <div class="status ">
                                    <span>Còn hàng</span>
                                    <span>Đã bán: <span class="special">3</span></span>
                                </div>
                            </div>
                        </div>
                    </div>
               
            </div>
        </div>
        
    </div>        
</div>