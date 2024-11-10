<head><link rel="stylesheet" href="../resources/css/card.css">

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="../resources/js/card.js"></script>
</head>
<body>
<section class="container-card">
  <div class="container-card-mini">
    <div class="card-title "> <!-- quay lai mua sam  -->
        <h5><a href="#!"><i class="fas fa-arrow-circle-left"></i>Continue shopping</a></h5>
        <hr>
        <div class="card-title-mini">
          <div class="pad-5" >
            <p>Shopping cart</p>
            <p>You have 4 items in your cart</p>
            <p><input id="chonhet" type="checkbox">Chọn tất cả  </p>
          </div>
         <div>
            <p><span>Sort by:</span> <a href="#!" id="sortPrice">price <i class="fas fa-angle-down"></i></a></p>
        </div>

        </div>
        <div class="container-card-product ">
<!-- --------------------Sản phẩm từ đây----------------------------------- -->
          
            <div class="card-product-item b2">
                  <div class="item-image pad-20">
                    <input name="chon" id="chon" value="1" class="chon" type="checkbox">
                    <div class="border-soild"><img src="https://lovearts.vn/wp-content/uploads/2020/12/mau-hoa-su-kien-hot-nhat-2020-1.jpg"
                    alt="Shopping item"> </div>
                      <div class="item-info">
                         <p>Iphone 11 pro</p>  <!-- tên sản phẩm-->
                        <p>256GB, Navy Blue</p><!--Đặc điểm-->
                      </div>
                  </div>
                   <div class="dis-flex" >
                    <p >Số lượng: &nbsp;<br>Giá:</p>
                    <p >2<br>300.000 </p>
                  </div>
                  <a href="#!"><i class="fas fa-trash-alt pad-5"></i></a>
            </div>
<!-- ------------------------------đặt hàng thanh toán ----------------------------------------->
       <div class="container-checkpay">
              <div class="b3 pad-5">
                <div class="title-checkpay dis-flex">
                  <h5>Card details</h5>
                  <img src="https://th.bing.com/th/id/OIP.HcH5UgkgVyznnnVyDWoSMAHaHa?rs=1&pid=ImgDetMain" alt="Avatar">
                </div>
                <!-- hinh thuc thanh toan -->
                  <p>Card type</p>
                  <a href="#!"><i class="fas fa-hand-holding-usd"></i> </a>
                  <a href="#!"><i class="fab fa-cc-visa" ></i></a>
                  <a href="#!"><i class="fas fa-money-check-alt "></i></a>
                  <a href="#!"><i class="fab fa-cc-paypal"></i></a>
                <!-- thong tin thanh toan -->
                <form class="infor-pay">
                  <div class="tenkhach">
                    <input type="text" id="typeName" placeholder="Cardholder's Name" />
                  </div>

                  <div class="sdtkhach">
                    <input type="text" id="typeText" placeholder="0534808827"  />
                   </div>
                  <div class="diachi">
                    <input type="text" id="typeText" placeholder="tp.Ho Chi Minh"  />
                    </div>                
                </form>
                <hr>
                <div class="tongphu">
                  <p>Subtotal</p>
                  <p>$4798.00</p>
                </div>
                <div class="vanchuyen">
                  <p>Shipping</p>
                  <p>$20.00</p>
                </div>
                <div class="tongcong">
                  <p>Total(Incl. taxes)</p>
                  <p>$4818.00</p>
                </div>
                <button type="button">
                  <div class="btn">
                    <span>$4818.00</span>
                    <span>Checkout <i></i></span>
                  </div>
                </button>
              </div>
          
          </div>
      
    </div>
   </div>
</section>
</body>
