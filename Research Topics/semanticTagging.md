# Semantic Tagging #

<img src='http://thales.cs.upb.de/smallscalestudies/mtsr2010/images/wordclouds/_day2.png'>

<h2>Overview</h2>

Semantics are the implied meaning of a subject, like a word or sentence. It aids how humans (and these days, machines) interpret subject matter. On the web, HTML serves both humans and machines, suggesting the purpose of the content enclosed within an HTML tag. Since the dawn of HTML, elements have been revised and adapted based on actual usage on the web, ideally so that authors can navigate markup with ease and create carefully structured documents, and so that machines can infer the context of the wonderful collection of data we humans can read.<br>
<br>
Until — and perhaps even after — machines can understand language and all its nuances at the same level as a human, we need HTML to help machines understand what we mean. A computer doesn’t care if you had pizza for dinner. It likely just wants to know what on earth it should do with that information.<br>
<br>
<h2>Usage</h2>

Findability is about making information easier to find. In addition to traditional controlled vocabulary-based indexing, information architecture has evolved to make browsing and navigation methods more effective, search engine capabilities have been improving to help us find the proverbial needle in the haystack, and bookmarking and social tagging have emerged to help us find our own content, and that we share with members of a social networking group.<br>
<br>
The various methods of enhancing findability each have their limitations. Traditional document indexing/material cataloging and web information architecture do not go deep enough. Indexing is usually at the document level, and cataloging only works on the level of the material as a whole. Information architecture aids in the navigation of a website, intranet, or portal, but in itself it is often not sufficient for finding specific information. Search engines match user-entered keywords and phrases to those found within the texts or metatag fields of documents, but these are still just word matches and do not necessarily go after the meaning of a document.<br>
<br>
New techniques and tools are being developed to address the shortcomings of these various approaches to finding information and to deliver better results in an increasingly competitive information industry. "Semantic tagging," in the various ways that it is understood, is a term that describes many of these new (and some not-so-new) findability approaches. Semantic tagging is by no means an accepted concept with an agreed upon definition. Other than the obvious "tagging for meaning," semantic tagging means different things to people coming from different parts of the information management field. It may be used interchangeably with "semantic indexing" in contexts where "indexing" is used for "tagging." Nevertheless, in the quest for better methods of findability, the term semantic tagging is starting to appear in descriptions of information services and products, blogs, online articles, and presentations.<br>
<br>
<h2>Semantic Tagging</h2>

<a href='http://www.youtube.com/watch?feature=player_embedded&v=O50GXw11748' target='_blank'><img src='http://img.youtube.com/vi/O50GXw11748/0.jpg' width='425' height=344 /></a><br>
<br>
"Semantic tagging" is a term that describes many of these new (and some not-so-new) findability approaches. Semantic tagging is by no means an accepted concept with an agreed upon definition. Other than the obvious "tagging for meaning," semantic tagging means different things to people coming from different parts of the information management field. It may be used interchangeably with "semantic indexing" in contexts where "indexing" is used for "tagging." Nevertheless, in the quest for better methods of findability, the term semantic tagging is starting to appear in descriptions of information services and products, blogs, online articles, and presentations.<br>
<br>
Semantic tagging (or annotation) is now one of the promising methodologies to define semantic structures on the content. Semantic tagging is the annotation of each content word with a semantic category.  A simple way to categorize<br>
semantic tagging systems is as follows:<br>
<br>
<ul><li>Machine-learning methods such as Amilcare that require an annotated training corpus;<br>
</li><li>Rules-based systems – that rely on manually-created rules;<br>
</li><li>Pattern-based systems – that require an initial set of seeds in order to discover patterns.</li></ul>

Armadillo uses a pattern-based approach to annotation, based on the Amilcare information extraction system. It is especially suitable for highly structured Web pages. The tool starts from a seed pattern and does not require human input initially - although the patterns for entity recognition have to be added manually.<br>
<br>
The knowledge and information management (KIM) platform consists of an ontology and knowledge base as well as an indexing and retrieval server. RDF data is stored in an RDF repository, whilst search is performed using LUCENE. KIM is based on an underlying ontology (KIMO or PROTON) that holds the knowledge required to semantically annotate documents, and on GATE to perform information extraction.<br>
<br>
Magpie is a suite of tools that supports the fully automatic annotation of Web pages, by mapping entities found in its internal knowledge base against those identified on Web pages. The quality of the results depends on the background ontology, which has to be manually modeled and populated.<br>
<br>
MnM is another tool that supports semi-automatic annotation based on the Amilcare system. It uses machine learning techniques and requires a training data set. The classical usage scenario MnM was designed for is the following: while browsing the Web, the user manually annotates selected Web pages in theMnM Web browser. While doing so, the system learns annotation rules, which are then tested against user feedback. The better the system does, the less user input is required.<br>
<br>
The PANKOW algorithm is a pattern-based approach to semantic annotation that makes use of the redundant nature of information on the Web. Based on an ontology, the system constructs patterns and combines entities into hypotheses that are validated manually. S-Cream is another approach to semi-automatic annotation that combines two tools: Ont-O-Mat, a manual annotation editor implementing the CREAM framework, and the Amilcare system. S-Cream can be trained for different domains provided the appropriate training data and proposes a set of heuristics for post-processing and mapping of information extraction results to an ontology. S-CREAM 12 uses the Amilcare machine-learning system together with a training corpus of a manually annotated set of documents, to automatically suggest appropriate tags for new documents.<br>
<br>
Con Annotator uses Support Vector Machines (SVM) and Natural Language processing (NLP) approaches to facilitate the automated generation of annotations with the support of the domain ontology.<br>
<br>
The Sem Tag system is based on the TAP ontology (which is very similar to the KIM ontology). The system firstly annotates all occurrences of instances of the ontology. Secondly, it disambiguates the elements and assigns the correct ontological classes by analysing context.<br>
<br>
More recently, the OntoNEO system has been developed by Choi and Park to automatically semantically annotate named entities in texts. OntoNEO claims to have 18% better performance than the Sem Tag algorithm – by using a Hidden Markov Model (HMM) to represent the probabilistic model<br>
of named entities from a corpus of documents.<br>
<br>
The SCORE system for management of semantic metadata (and data extraction) also contains a component for resolving ambiguities. SCORE uses associations from a knowledgebase to determine the best match from candidate entities but detailed implementation details are not available.<br>
<br>
In ESpotter, named entities are recognized using a lexicon and/or patterns. Ambiguities are resolved by using the URI of the webpage to determine the most likely domain of the term.<br>
<br>
<h2>Semantic Searching</h2>

<a href='http://www.youtube.com/watch?feature=player_embedded&v=-R87nJi9YyQ' target='_blank'><img src='http://img.youtube.com/vi/-R87nJi9YyQ/0.jpg' width='425' height=344 /></a><br>
<br>
Semantic search seeks to improve search accuracy by understanding searcher intent and the contextual meaning of terms as they appear in the searchable dataspace, whether on the Web or within a closed system, to generate more relevant results. Author Seth Grimes lists "11 approaches that join semantics to search", and Hildebrand et al. provide an overview that lists semantic search systems and identifies other uses of semantics in the search process. Semantic search systems consider various points including context of search, location, intent, variation of words, synonyms, generalized and specialized queries, concept matching and natural language queries to provide relevant search results. Major web search engines like Google and Bing incorporate some elements of semantic search.<br>
<br>
Guha et al. distinguish two major forms of search: navigational and research. In navigational search, the user is using the search engine as a navigation tool to navigate to a particular intended document. Semantic search is not applicable to navigational searches. In research search, the user provides the search engine with a phrase which is intended to denote an object about which the user is trying to gather/research information. There is no particular document which the user knows about and is trying to get to. Rather, the user is trying to locate a number of documents which together will provide the desired information. Semantic search lends itself well with this approach that is closely related with exploratory search.<br>
<br>
Rather than using ranking algorithms such as Google's Page Rank to predict relevancy, semantic search uses semantics, or the science of meaning in language, to produce highly relevant search results. In most cases, the goal is to deliver the information queried by a user rather than have a user sort through a list of loosely related keyword results. However, Google itself has subsequently also announced its own Semantic Search project.<br>
<br>
Other authors primarily regard semantic search as a set of techniques for retrieving knowledge from richly structured data sources like ontologies as found on the Semantic Web. Such technologies enable the formal articulation of domain knowledge at a high level of expressiveness and could enable the user to specify his intent in more detail at query time.<br>
<br>
<h2>Sources</h2>

<ul><li><a href='http://www.econtentmag.com/Articles/Editorial/Feature/How-Semantic-Tagging-Increases-Findabillity-50700.htm'>http://www.econtentmag.com/Articles/Editorial/Feature/How-Semantic-Tagging-Increases-Findabillity-50700.htm</a>
</li><li><a href='http://www.itee.uq.edu.au/eresearch/projects/ands/W4SemanticTagging-report-2011-02.pdf'>http://www.itee.uq.edu.au/eresearch/projects/ands/W4SemanticTagging-report-2011-02.pdf</a>
</li><li><a href='http://en.wikipedia.org/wiki/Semantic_search'>http://en.wikipedia.org/wiki/Semantic_search</a>
</li><li><a href='http://html5doctor.com/lets-talk-about-semantics/'>http://html5doctor.com/lets-talk-about-semantics/</a>
</li><li><a href='http://www.econtentmag.com/Articles/Editorial/Feature/How-Semantic-Tagging-Increases-Findabillity-50700.htm'>http://www.econtentmag.com/Articles/Editorial/Feature/How-Semantic-Tagging-Increases-Findabillity-50700.htm</a>