import QtQuick 2.15
import QtQuick.Controls 2.15

ApplicationWindow {
    visible: true
    width: 900
    height: 600
    title: "Happy Frontend"

    ListView {
        anchors.fill: parent
        model: gameModel

        delegate: Rectangle {
            width: parent.width
            height: 60

            Text {
                text: title
                anchors.centerIn: parent
            }

            MouseArea {
                anchors.fill: parent
                onClicked: {
                    console.log("Launch:", title)
                }
            }
        }
    }
}
