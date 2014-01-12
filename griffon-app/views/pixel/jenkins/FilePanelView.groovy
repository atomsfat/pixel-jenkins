package pixel.jenkins


actions{
  action(id: 'saveAction',
    enabled: bind {model.dirty},
    name: 'Save',
    mnemocic: 'S',
    closure: controller.saveFile
  )
  action(id : 'closeAction',
    name: "close",
    mnemocic: "C",
    accelerator: shortcut('C'),
    closure: controller.closeFile
  )
}
tabbedPane(tabGroup, selectedIndex: tabGroup.tabCount){
  panel(title: tabName, id: 'tab'){
    borderLayout()
    scrollPane(constraints: CENTER){
      textArea(id: 'editor', text: bind{model.fileText})
    }
    hbox(constraints: SOUTH){
      button saveAction
      button closeAction
    }
  }
}
bean(model, dirty:bind {editor.text != model.fileText})
