# Teletype Markup Language (TTML) Intellij Idea Plugin

TTML is an ASCII based markup language using [ASCII control characters][7] for markup command reference. The language
has been developed by [Oren Watson][8] in 2014 and is intended for all kinds of documents with distinct mathematical /
scientific looks.

This plugin has been developed in the framework of a Software Developer Intern test task. The implementation duration
for this task has been set by JetBrains to two weeks (07.12.2021 - 23.12.2021). This document serves as reference and
implementation summary.

You can use the provided `TTML_Sample.ttml` file for testing purposes, which is located in the root of this project.

## Features

Following the JetBrains [Custom Language Support Tutorial][1], the following steps have been implemented:

1. Prerequisites
2. Language and File Type
3. Grammar and Parser
4. Lexer and Parser Definition
5. Syntax Highlighter and Color Settings Page
6. PSI Helpers and Utilities
7. ~~Annotator~~
8. ~~Line Marker Provider~~
9. Completion Contributor
10. ~~Reference Contributor~~
11. ~~Find Usages Provider~~
12. ~~Folding Builder~~
13. ~~Go To Symbol Contributor~~
14. Structure View Factory
15. ~~Formatter~~
16. ~~Code Style Settings~~
17. Commenter
18. ~~Quick Fix~~

- _Crossed elements have not been implemented_
- _TTML does not define comments. Commenting is implemented to show implementation skill_

## Implementation Log

- 09.12.2021: Received task per mail; Task understanding and planning.
- 10.12.2021: First impression of TTML; Playing with partial Perl implementation
- 11.12.2021: Information gathering regarding Oren Watson and TTML
- 12.12.2021: Study of Jetbrains Custom Language Support Tutorial
- 13.12.2021: Setting up prerequisites for plugin development
- 14.12.2021: Prototype Grammar and Lexer definition
- 15.12.2021: Grammar and Lexer finalization
- 16.12.2021: Syntax Highlighter and Color Settings Page implementation
- 17.12.2021: Structure View Factory implementation 1/2
- 18.12.2021: Structure View Factory implementation 2/2
- 19.12.2021: Commenter implementation 1/2 (Not required by the language)
- 20.12.2021: Commenter implementation 2/2 (Not required by the language)
- 21.12.2021: Processing of task 1 (Explain why this project compels you)
- 22.12.2021: Finalising the project

## Language Semantics

Oren Watson, the inventor of the TTML intended a very specific vocabulary as a basis for his language. A defined
[ASCII table][5] includes only the most common and basic alphanumerical and special characters. In this context, Unicode
is not in the languages' vocabulary and cannot be used within the markdown definition.

TTML keywords are introduced by `^` and defined position independent. Keywords can appear without separators, within
text, and can be terminated or reset without usage. The language example shown at [Esolang][2] demonstrates most keyword
behaviour and usages. However, the actual implementation of many keywords is unclear, not explained or not demonstrated.

Please note that the provided partial [Perl implementation][6] is in parts conflicting with language documentations and
therefore cannot be taken as implementation or language reference. Oren Watson's implementation chat at [Freenode][3]
gave crucial information about what he originally intended to do with his language, how his language developed and why
he ended the project.

### Command Remarks

- `^@` is not used for introducing comments or ignoring blocks. The command is simply ignored.
- `^D` The meaning and markup intend for this keyword is not defined.
- `^I` This command can not be used with mono space fonts (moves cursor one half char forward).
- `^K` This command can not be used with mono space fonts (moves cursor down one half-line).
- `^[` The intended usage for hyperlinks is not demonstrated nor documented. It is unclear how to use this command.
- `^]` The intended usage for hyperlinks is not demonstrated nor documented. It is unclear how to use this command.

### Required Elements

TTML explicitly defines no required elements. However, based on the provided documentation it is likely that specific
language features are strongly related and in this context require the presence of certain start and end tags:

- Hyperlinks: Require starting `^[` and ending `^]` elements.

## Resources

- [Esolang TTML][2] - Documentation and Reference
- [TTML Freenode][3] - Oren Watson Implementation Chat
- [Oren Watson Pastebin][4] - TTML Oren Watson Pastebin
- [Oren Watson ASCII][5] - Special ASCII Interpretation
- [Perl Implementation][6] - Partial Implementation
- [ASCII Control Characters][7] - Control Character Overview

[1]: https://plugins.jetbrains.com/docs/intellij/custom-language-support-tutorial.html

[2]: https://esolangs.org/wiki/TTML

[3]: https://logs.esolangs.org/freenode-esoteric/2014-12.txt

[4]: https://pastebin.com/u/OrenWatson

[5]: http://www.orenwatson.be/ascii.txt

[6]: https://pastebin.com/0kifNgpd

[7]: https://en.wikipedia.org/wiki/Control_character

[8]: http://www.orenwatson.be/
