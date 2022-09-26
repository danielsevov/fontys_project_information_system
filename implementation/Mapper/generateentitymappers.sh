#!/bin/bash

package=''
if [ $# -lt 2 ]; then
    echo "usage: $0 <source dir> <package>"
    exit 1
fi

dir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"
cd "$1" || exit 1
package=$2; shift

echo "package = $package"
classestomap=""

if [ -d target/classes/${package} ]; then
    for c in $(find target/classes/${package} -name "*.class" -type f | grep -v Mapper.class | sed -e's#target/classes/##g;s#/#.#g;s#.class##') ; do
	classestomap="${classestomap} ${c}"
    done
else
    echo "package not available in target/classes"
fi
if [ -d target/test-classes/${package} ]; then
    for c in $(find target/test-classes/${package} -name "*.class" -type f | grep -v Mapper.class  | sed -e's#target/test-classes/##g;s#/#.#g;s#.class##') ; do
	classestomap="${classestomap} ${c}"
    done
else
    echo "package not available in target/test-classes"
fi

#annojar=${HOME}/.m2/repository/nl/fontys/sebivenlo/sebiannotations/1.0-SNAPSHOT/sebiannotations-1.0-SNAPSHOT.jar
echo "package ${package} has classes to map:  [$classestomap]"

cd "$dir" || exit 1
java -cp target/genericmapper-jar-with-dependencies.jar:target/classes:target/test-classes genericmapper.MapperGenerator $(echo ${classestomap})

