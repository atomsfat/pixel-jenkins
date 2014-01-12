application {
    title = 'PixelJenkins'
    startupGroups = ['pixel-jenkins']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "filePanel"
    'FilePanel' {
        model      = 'pixel.jenkins.FilePanelModel'
        view       = 'pixel.jenkins.FilePanelView'
        controller = 'pixel.jenkins.FilePanelController'
    }

    // MVC Group for "pixel-jenkins"
    'pixel-jenkins' {
        model      = 'pixel.jenkins.PixelJenkinsModel'
        view       = 'pixel.jenkins.PixelJenkinsView'
        controller = 'pixel.jenkins.PixelJenkinsController'
    }

}
