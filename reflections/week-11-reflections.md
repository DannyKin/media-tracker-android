# Week 11 Reflection

**Name:** Danny King
**Date:** 07/30/2026

## Commits This Week

**Link:** https://github.com/DannyKin/media-tracker-android/pull/10

## Code Review

**Reviewed:** Hunter Bammert-Mueller
**Link to my review:** https://github.com/Hunterbounty11/media-tracker-android/pull/10

### What I Looked At

I reviewed the code he did for the priority part of the project. It looked like he was trying to have each item have a priority that ranges from high to low priority. I mainly focused on the priority screen to figure out how it is going to work. 

### What I Noticed

Well I didn't notice a  bug, but I was wondering why he created a priority list in the fakemediarepository. Does it matter if it's there or not?

### Comments I Left

I commented about his priority list in the fakemediarepository and if it was needed. I also like how he created a priority serializable page.

## One Thing I Understood More Deeply

I understood how my bonus feature - quotes works.  The QuotesViewModel stores and manages the UI data for the Quotes screen. In the QuotesScreen, the StateFlow is collected and runs once when the screen is first shown and starts downloading the user's quotes. Lastly the LazyColumn display one QuoteCard for each Quote in the list.

## One Thing I'm Still Confused About

I'm not currently confused on anything, but I do need your help because my project is not running right now, so I was wondering if you could help me fix it. 

## Anything Else *(optional)*

## Rubric

*You don't need to self-assess — this is here so you know what I'm looking at.*

| Section | Points | Full Credit | Half Credit | No Credit |
|:---|:---:|:---|:---|:---|
| **Reflection** | 10 | Specific, honest responses to "More Deeply" and "Still Confused" sections. Shows genuine thinking — not just "I learned X." | Responses are present but vague or generic ("I got better at Compose"). | Missing or one-word answers. |
| **Code Review** | 10 | Specific observation about the code with explanation of why it matters (or a substantive positive comment). Link to review present and verified. | A question or comment that shows you read the code, but lacks explanation. | "Looks good!" or equivalent. Missing link. Review not found on GitHub. |
| **Total** | **20** | | | |

**A note on the code review score:** I check that the review actually exists on GitHub before grading. The written summary here and the GitHub comment should match. If the review isn't there, the written summary can't earn credit.
