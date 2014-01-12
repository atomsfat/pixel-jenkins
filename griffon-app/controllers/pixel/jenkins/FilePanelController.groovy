package pixel.jenkins

class FilePanelController {
    // these will be injected by Griffon
    def model
    def view

    void mvcGroupInit(Map args) {
        // this method is called after model and view are injected
      model.loadedFile = args.file
      model.mvcId = args.mvcId
      execOutsideUI {
        String text = model.loadedFile.text
        execInsideUIAsync {
          model.fileText = text
        }
      }
    }

    // void mvcGroupDestroy() {
    //    // this method is called when the group is destroyed
    // }

    /*
        Remember that actions will be called outside of the UI thread
        by default. You can change this setting of course.
        Please read chapter 9 of the Griffon Guide to know more.
     */
    def saveFile = {
      execOutsideUI{
        model.loadedFile.text = view.editor.text
        execInsideUIAsync{ model.fileText = view.editor.text}
      }
    }
    def closeFile = {
      view.tabGroup.remove(view.tab)
      destroyMVCGroup(model.mvcId)
    }

}
