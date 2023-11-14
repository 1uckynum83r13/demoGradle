function getNotes() {
    fetch("/api/notes")
        .then(response => {
            if (!response.ok) {
                throw new Error("HTTP error! status: ${response.status}");
            }
            return response.json();
            })
            .then(notes => {
                const notesList = document.getElementById("notesList");
                notesList.innerHTML = "";
                notes.forEach(note => {
                    notesList.appendChild(createNoteElement(note));
                });
            })
            .catch(error => {
                console.error("Error fetching the notes:", error);

            });
}

function createNoteElement(note) {
    const listItem = document.createElement("li");
    listItem.setAttribute("data-id", note.id);

    const noteTitle = document.createElement("div");
    noteTitle.className = "note-content";
}