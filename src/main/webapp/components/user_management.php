<link rel="stylesheet" href="user_management.css" />
<div class="user-management-container">
    <div class="search-container">
        <form id="searchForm">
            <input type="text" placeholder="Tìm kiếm..." name="search" id="searchInput">
            <button type="submit"><i class="fa fa-search"></i></button>
            <button type="button" id="addUserButton">Thêm người dùng</button>
        </form>
    
        <div class="user-list" id="userList">
          <!-- Users will be displayed here -->
        </div>
    </div>
    <div class="user-add">
        <form action="add-user.php" method="post" enctype="multipart/form-data">
            <label for="name">Tên người dùng:</label>
            <input type="text" id="name" name="name" required><br><br>
        
            <label for="city">Tỉnh:</label>
            <input type="text" id="city" name="city" required><br><br>

            <label for="district">Quận/Huyện:</label>
            <input type="text" id="district" name="district" required><br><br>

            <label for="ward">Phường/Xã:</label>
            <input type="text" id="ward" name="ward" required><br><br>
        
            <label for="avatar">Ảnh đại diện:</label>
            <input type="file" id="avatar" name="avatar"><br><br>

            <label for="phone_number">Điện thoại:</label>
            <input type="number" id="phone_number" name="phone_number" required><br><br>
        
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required><br><br>
        
    

            <input type="submit" value="Thêm Người Dùng">
        </form>
    </div>

    <div class="user-edit" style="display: none;">
        <form id="editUserForm" action="edit-user.php" method="post" enctype="multipart/form-data">
            <input type="hidden" id="editUserId" name="id">
            <label for="editName">Tên người dùng:</label>
            <input type="text" id="editName" name="name" required><br><br>
    
            <label for="editCity">Tỉnh:</label>
            <input type="text" id="editCity" name="city" required><br><br>

            <label for="editDistrict">Quận/Huyện:</label>
            <input type="text" id="editDistrict" name="district" required><br><br>

            <label for="ward">Phường/Xã:</label>
            <input type="text" id="editWard" name="ward" required><br><br>
        
            <label for="editAvatar">Ảnh Bìa:</label>
            <input type="file" id="editAvatar" name="avatar"><br><br>

            <label for="editPhone_number">Điện thoại:</label>
            <input type="number" id="editPhone_number" name="phone_number" required><br><br>
        
            <label for="editEmail">Email:</label>
            <input type="text" id="editEmail" name="email" required><br><br>

            <input type="submit" value="Cập Nhật Thông Tin Người Dùng">
        </form>
    </div>
</div>

<script>
        /*list tạm do không có data */
        const users = [
            { id: 1, name: 'User 1', image: 'resources/images/avatar.jpg'},
            { id: 2, name: 'User 2', image: 'resources/images/avatar.jpg'},
            { id: 3, name: 'User 3', image: 'resources/images/avatar.jpg'},
            { id: 4, name: 'User 4', image: 'resources/images/avatar.jpg'}
        ];
        /* ẩn hiện form thêm user */ 
        document.getElementById('addUserButton').addEventListener('click', function() {
            document.querySelector('.user-management-container').classList.toggle('show-add-user');
        }); 
        /* tìm kiếm các thứ */
        document.getElementById('searchForm').addEventListener('submit', function(event) {
            event.preventDefault();
            const query = document.getElementById('searchInput').value.toLowerCase();
            const filteredUsers = users.filter(user => user.name.toLowerCase().includes(query));
            displayUsers(filteredUsers);
        });
        /* hiện user được tìm */
        function displayUsers(users) {
            const userList = document.getElementById('userList');
            userList.innerHTML = '';
            users.forEach(user => {
                const userItem = document.createElement('div');
                userItem.className = 'user-item';
                userItem.innerHTML = `
                    <img src="${user.image}" alt="${user.name}">
                    <h3>${user.name}</h3>

                    <button class="edit-button" onclick="editUser(${user.id})">Sửa</button>
                    <button class="delete-button" onclick="deleteUser(${user.id})">Xóa</button>
                `;
                userList.appendChild(userItem);
            });
        }
        /*thêm thông tin cho bảng sửa các thứ*/
        function editUser(userId) {
            const user = users.find(p => p.id === userId);
            if (user) {
                document.getElementById('editUserId').value = user.id;
                document.getElementById('editName').value = user.name;
                

                document.querySelector('.user-add').style.display = 'none';
                document.querySelector('.user-edit').style.display = 'block';
            }
        }
        /*ẩn form các thứ*/
    document.getElementById('addUserButton').addEventListener('click', function() {
    document.querySelector('.user-add').style.display = 'block';
    document.querySelector('.user-edit').style.display = 'none';
});

    function deleteUser(id) {
        alert('Xóa tài khoản ID: ' + id);
        // Thêm mã để xử lý xóa tại đây
    }
</script>
