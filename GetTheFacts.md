# Get The Facts: eID Applet Identification #

Via this article we want to highlight some of the features and advantages of the improved architecture of the new eID Applet. We will compare different aspects of the new eID Applet against the eID Middleware (MW) SDK Applet version 3.5. This article should allow you to make better choices when integrating eID operations within your web applications. The scope of this article is limited to eID Identification only as the old eID Applet only supports identification. Though keep in mind that the new eID Applet also offers eID authentication and creation of eID signatures.

## Minimal Browser Requirements ##

As opposed to the eID MW SDK Applet (referred to as old eID Applet), where you need to load native libraries depending on the actual client platform, the new eID Applet places minimal requirements on the browser runtime environment. The only requirement is the availability of Java 6 on the client platform. Using the Java 6 Deployment Toolkit Javascript we can even offer automatic installation of the Java runtime on the client platform. Furthermore the new eID Applet has no requirements on the eID Middleware whatsoever. The new eID Applet can operate both with or without the eID Middleware installed on the client platform. Given the small size of the new eID Applet (about 120 KiB, comparable with the size of a JPEG image) we are able to yield maximum eID user experience as part of your web applications.

## Data Integrity ##
Compared to the old eID Applet, the new eID Applet offers true identity data integrity. Where the old eID Applet parses the identity and address files on the client machine, the new eID Applet operates via an eID Applet Service server-side component for integrity verification. Parsing the identity and address files on the client machine itself completely voids the data integrity features foreseen by the eID card. A hacker can easily forge the data send over by the client if the data integrity verification does not happen at the server side. Client-side integrity verification is just plain nonsense. As opposed to the old eID Applet, the new eID Applet architecture offers an eID Applet Service as a server-side component. This component verifies the integrity of the identity and address files at the server-side. The eID Applet Service will only parse the identity and address files after a successful verification of the digital signature created by the National Registry. If you precede the eID identification with an eID authentication you can even be assured that the identity data has not been forged by some man-in-the-middle.

## Privacy ##
As Web 2.0 web applications these days become more and more oriented towards community and user-centric experience, Javascript based cross-site scripting attacks are very likely to hit your web site one day. Since the old eID Applet passes the parsed identity and address data to the web application via some Javascript you could run into serious security and privacy issues once your web site is under attack.  Because the web page has direct access to the identity data via Javascript, your web application (and company) could run into serious privacy issues. As opposed to the old eID Applet, the architecture of the new eID Applet has been designed to specifically tackle various security risks which come with tomorrow's web applications where dynamic user-authored content has become commodity. With the new eID Applet, the web pages of your web application can no longer directly access the identity and address data from within Javascript. This setup voids all kind of Javascript based cross-site scripting attacks and offers maximum privacy protection of your users. Instead, the identity data is only released after explicit user consent and after interaction with the server-side web application.

## Security ##
The old eID Applet does not handle the communication of the identity and address data itself but leaves this to the web application. Because of this construction, there is a possibility that the user's sensitive identity data is communicated to the server over an insecure connection. The design of the architecture of the new eID Applet also offers improvements in this area. The new eID Applet communicates the identity and address data itself over a secured SSL tunnel, thus preventing eavesdroppers from attacking your site and preventing the extraction of valuable user base information.

As Windows systems become more and more polluted with Trojan horses and computer viruses, it is of eminent importance to limit the window of opportunity for malware to abuse the user's eID card. The new eID Applet offers a feature where the user is asked to remove the eID card after readout to limit this risk.

## User Experience ##
In the context of the new Web 2.0 web applications, the user experience offered by the old eID Applet is no longer sufficient. These days the technology is already available to offer interactive eID card handling where the user is requested to insert his/her eID card upon request. The new eID Applet exposes such a rich user experience and allows for general adoption of eID operations within future web applications. Furthermore the internationalization of the new eID Applet no longer depends on the eID Middleware installation settings, but upon the settings of the user within your web application.

## Distribution Model ##
When it comes to software, the applicable distribution model for software updates becomes a major aspect. The distribution model for the new eID Applet is mush better compared to the distribution model of the old eID Applet. First of all the new eID Applet has no hard dependency upon the eID Middleware. So if the new eID Applet doesn't like the installed eID Middleware, it just bypasses it and continues to work as expected. In the second place, updates of new eID Applet are communicated via the eID-Applet mailing list and put in place by a relative small group of web masters. The distribution model of the old eID Applet fails in both these areas. For the old eID Applet it is not that easy. As the old eID Applet depends upon the installed eID Middleware on the client machine, you can easily run into trouble when the eID Applet doesn't like the installed eID Middleware. Who's to blame at that point? The client that runs a more recent eID Middleware compared to the SDK eID Applet? Or the web master who didn't update the SDK eID Applet deployed in his web applications? So in case of trouble, what shall we update? SDK eID Applet or installed eID Middleware? Another point of trouble is the lack of communication; it's impossible to inform all citizens that they should install a new eID Middleware to be able to use a certain web application. eID Middleware automatic updates wouldn't help either because of the huge diversity in client platforms. So it's definitely fun all over the place.

## Service Desk Support ##
One quite annoying thing with the old eID Applet is that you never know exactly what went wrong when it fails to run. The new eID Applet comes with a console displaying log messages detailing on its internals (after pressing the 'Details' button). This can be of great aid when the eID Applet refuses to run on a client machine. The logger even comes with a context menu allowing to directly send a logging report to the eID Applet mailing list. This can be of valuable help towards the service desk and can greatly reduce the time spend on a case.