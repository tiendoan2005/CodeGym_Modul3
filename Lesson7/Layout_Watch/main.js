function showMusic(musicID) {
    // Ẩn tất cả các iframe trước khi hiển thị cái mới
    document.querySelectorAll('.music iframe').forEach(function(iframe) {
        iframe.style.display = 'none';
    });

    // Hiển thị iframe tương ứng với ID được truyền vào
    let music = document.getElementById(musicID);
    if (music) {
        music.style.display = 'block';
    }
}