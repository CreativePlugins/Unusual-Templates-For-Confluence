import find from 'lodash/find'


export function insertContent(content) {
    tinyMCE.activeEditor.execCommand('mceInsertContent', false, content);
}

export function addShortcutInsert(shortcut, descr, content) {
    tinyMCE.activeEditor.addShortcut(shortcut, descr, function () {
        insertContent(content);
    });
}

export function addShortcutModal(shortcut, descr, modalId) {
    //ToDo: add modal window for parametrized templates
}

export function removeShortcutByDescription(descr) {
    delete find(tinyMCE.activeEditor.shortcuts, {"desc": descr});
}

