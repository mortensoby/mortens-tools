import java.awt.Desktop

String mailToRemove = args ? args[0] : null
def mailList = 'https://nine.dk/mennesker/'.toURL().text.findAll(/mailto:.{3}@nine.dk/).collect { it.drop(7) }

if (mailToRemove) {
    def removed = mailList.remove(mailToRemove)
    if(removed){
        println("Removed ${mailToRemove} from list")
    }else {
        println("The mail ${mailToRemove} was not in the list, so the program quit")
        System.exit(1)

    }
}
def mailsCommaSeperated = mailList.join(',')

String body = 'Brødtekst'
String subject = 'Indsamling'
String url = "https://mail.google.com/mail/u/1/?fs=1&su=${subject}&body=${body}&to=${mailsCommaSeperated}&tf=cm"
Desktop.desktop.browse url.toURI()




