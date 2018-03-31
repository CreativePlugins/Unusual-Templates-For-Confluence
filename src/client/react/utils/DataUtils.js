let appData = null;
let observer = null;

function emitChange() {
    observer(appData);
}

export function observe(o) {
    if (observer) {
        throw new Error('Multiple observers not implemented.');
    }

    observer = o;
    emitChange();

    return () => {
        observer = null;
    };
}

export function initData(data) {
    appData = data;
}