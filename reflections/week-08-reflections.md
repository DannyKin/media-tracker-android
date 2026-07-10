# Week 08 Reflection

**Name:** Danny King
**Date:** 07/09/2026

## Commits This Week

**Link:** https://github.com/DannyKin/media-tracker-android/pull/8

## Code Review

**Reviewed: Hunter Bammert-Mueller
**Link to my review:** https://github.com/Hunterbounty11/media-tracker-android/pull/8

### What I Looked At

I looked at his media detail view model page because I'm struggling to figure it out. I want to take some ideas from him to see if it will help me.

### What I Noticed

I noticed that he fixed his search screen code, and it looks ike it will work fine now. He forgot to add a serialization to his code. Without it his code wasn't working properly.

### Comments I Left

I talked about how he finally figure out his search screen not working and his great use of sealed class on the media detail view model page.

## One Thing I Understood More Deeply

I understood how to wire `GET /reviews?mediaId={id}` to replace your hardcoded review cards. I'm gonna work on it alone and try to finish it by this weekend.

## One Thing I'm Still Confused About

I still confused on the first part of class. I couldn't figure out how to replace the hardcoded item with a real `GET /media/{id}` call, using the `mediaId` already flowing into the screen.

## Anything Else *(optional)*

I was frustrated by not being able to replace the hardcode in the beginning of class. 

## Rubric

*You don't need to self-assess — this is here so you know what I'm looking at.*

| Section | Points | Full Credit | Half Credit | No Credit |
|:---|:---:|:---|:---|:---|
| **Reflection** | 10 | Specific, honest responses to "More Deeply" and "Still Confused" sections. Shows genuine thinking — not just "I learned X." | Responses are present but vague or generic ("I got better at Compose"). | Missing or one-word answers. |
| **Code Review** | 10 | Specific observation about the code with explanation of why it matters (or a substantive positive comment). Link to review present and verified. | A question or comment that shows you read the code, but lacks explanation. | "Looks good!" or equivalent. Missing link. Review not found on GitHub. |
| **Total** | **20** | | | |

**A note on the code review score:** I check that the review actually exists on GitHub before grading. The written summary here and the GitHub comment should match. If the review isn't there, the written summary can't earn credit.
