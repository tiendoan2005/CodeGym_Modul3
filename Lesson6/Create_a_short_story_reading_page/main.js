function showStory(storyId) {
    let storyDiv = document.getElementById(storyId);

    if (storyDiv.style.display === 'block') {
        storyDiv.style.display = 'none';
    }else{
        storyDiv.style.display = 'block';
    }
}