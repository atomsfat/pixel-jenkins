package pixel.jenkins

import groovy.beans.Bindable

class FilePanelModel {
  File loadedFile
  @Bindable String fileText
  @Bindable boolean dirty
  String mvcId
}