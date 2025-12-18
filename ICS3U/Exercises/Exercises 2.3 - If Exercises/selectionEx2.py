docName = input("enter name of document >> ")
docEnglishNames = {
    ".png": "PNG picture file",
    ".docx": "word document",
    ".gif": "GIF (graphics interchange format)",
    ".mov": ".mov video file",
    ".mp4": "mpeg 4 video file",
    ".mp3": "mpeg 3 audio file",
    ".txt": "basic text file",
    ".py": "python program",
    ".cpp": "c++ program", 
    ".jpg": "jpg image file",
    ".java": "java program",
    ".rs": "rust program (very cool)"
}

extension = "." + docName.split(".")[1]
if not extension in list(docEnglishNames):
    print(f"your file is a {extension} file")
else:
    print(f"your file is a {docEnglishNames[extension]}")