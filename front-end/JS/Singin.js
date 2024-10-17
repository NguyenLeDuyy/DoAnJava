function cancelForm()
{
    var modal = document.getElementById('id01');
    var form = document.getElementById('signupForm');
    form.reset(); // Đặt lại form
   
}

// Khi người dùng click bất kỳ đâu bên ngoài modal, đóng modal
window.onclick = function (event)
{
    var modal = document.getElementById('id01');
    if (event.target == modal)
    {
        modal.style.display = "none";
    }
}