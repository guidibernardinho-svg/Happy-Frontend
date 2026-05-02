#include <QProcess>
#include <QStringList>

void launchRetroArch(QString core, QString rom)
{
    QProcess::startDetached("retroarch", QStringList()
        << "-L" << core
        << rom
    );
}

void launchPCSX2(QString iso)
{
    QProcess::startDetached("pcsx2", QStringList()
        << iso
    );
}
