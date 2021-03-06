package pixel.jenkins

import javax.swing.JFileChooser

class PixelJenkinsController {
    // these will be injected by Griffon
    def model
    def view

    // void mvcGroupInit(Map args) {
    //    // this method is called after model and view are injected
    // }

    // void mvcGroupDestroy() {
    //    // this method is called when the group is destroyed
    // }

    /*
        Remember that actions will be called outside of the UI thread
        by default. You can change this setting of course.
        Please read chapter 9 of the Griffon Guide to know more.
       
    def action = { evt = null ->
    }
    */
    def openFile = {
      def openResult = view.fileChooserWindow.showOpenDialog()
      if(JFileChooser.APPROVE_OPTION == openResult){
        File file = new File(view.fileChooserWindow.selectedFile.toString())
        String mvcId = file.path + System.currentTimeMillis()
        createMVCGroup('FilePanel', mvcId, [file:file, tabGroup: view.tabGroup, tabName:file.name, mvcId:mvcId])

      }

    }
  def quit = {
    app.shutdown()
  }
}
