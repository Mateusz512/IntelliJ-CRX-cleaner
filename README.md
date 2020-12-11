# IntelliJ-CRX-cleaner

<!-- Plugin description -->
This plugin takes care of manually removing obsolete XML tag properties for JCR content.

Simply hit that <kbd>Ctrl</kbd> + <kbd>Alt</kbd> + <kbd>L</kbd> and watch the magic happen.

![A demo of the plugin](https://github.com/Mateusz512/IntelliJ-CRX-cleaner/raw/main/doc/crx-cleaner.gif)

Can be:
* used on files
* used on directories
* added as pre-commit step

List of removed properties (inspired by [Gradle AEM Plugin](https://github.com/Cognifide/gradle-aem-plugin/blob/master/docs/package-sync-plugin.md#default-cleaning-configuration)):
```
jcr:lastModified.*
jcr:created.*
jcr:isCheckedOut
cq:lastReplicat.*
cq:lastModifi.*
dam:extracted
dam:assetState
dc:modified
.*_x0040_.*
jcr:uuid
```

<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "IntelliJ CRX Cleaner"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/Mateusz512/IntelliJ-CRX-cleaner/releases/latest) and install it manually using
  <kbd>Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template


## License

Licensed under the [Apache License, Version 2.0 (the "License")](https://www.apache.org/licenses/LICENSE-2.0.txt)
