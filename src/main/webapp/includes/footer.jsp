<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<footer>
       <div id="footer">

            <div id="twitter">
                <h3>TWITTER FEED</h3>
                	<time datetime="2012-10-23"><a href="#">23 oct</a></time>
                <p>
                	It was the moment I realized what music can do to people, how it can make you hurt and feel so good all at once.
                </p>
            </div>

            <div id="sitemap">
                <h3>SITEMAP</h3>
                	<div>
                		<a href="/home/">
                		    <fmt:message key="footer.home"/>
                		</a>

                		<a href="/about/">
                		    <fmt:message key="footer.about"/>
                		</a>

                		<a href="/services/">
                		    <fmt:message key="footer.services"/>
                		</a>
                	</div>
                	<div>
                		<a href="/partners/">
                		    <fmt:message key="footer.partners"/>
                		</a>

                		<a href="/customers/">
                		    <fmt:message key="footer.support"/>
                		</a>

                		<a href="/contact/">
                		    <fmt:message key="footer.contact"/>
                		</a>
                	</div>
            </div>

            <div id="social">
                <h3>SOCIAL NETWORKS</h3>
                	<a href="http://twitter.com/" class="social-icon twitter"></a>
                	<a href="http://facebook.com/" class="social-icon facebook"></a>
                	<a href="http://plus.google.com/" class="social-icon google-plus"></a>
                	<a href="http://vimeo.com/" class="social-icon vimeo"></a>
                	<a href="http://youtube.com/" class="social-icon youtube"></a>
                	<a href="/rss/" class="social-icon rss"></a>
            </div>

            <div id="language">
                <h3>LANGUAGE</h3>
                <a href="controller?locale=en&command=changeLocale">EN</a>
                <a href="controller?locale=ru&command=changeLocale">RU</a>
            </div>

            <div id="footer-logo">
                    <a href="/"><img src="resources/img/logo.png" alt="logo" width=300></a>
                    	<p>Copyright © 2012 SampleShop. A <a href="http://SampleShop.com">SampleShop</a> creation</p>
            </div>
       </div>
</footer>
