package SwipeLeftPage;

import Utils.Base;

public class SwipeLeftPage extends Base {
    public SwipeLeftObjectRepo deleteChat;

    public SwipeLeftPage(){ deleteChat= new SwipeLeftObjectRepo(driver);}

    public String getToastMessageAfterDeletingChat() throws InterruptedException {
        deleteChat.swipe.click();
        Thread.sleep(2000);
        //swipeLeft(deleteChat.firstMsg);

        SwipeLeftAgain(deleteChat.firstMsg);
       String toastMsg = deleteChat.toast.getText();
       return toastMsg;
    }
}
