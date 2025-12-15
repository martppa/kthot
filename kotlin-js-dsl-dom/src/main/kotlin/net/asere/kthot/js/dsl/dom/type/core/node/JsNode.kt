package net.asere.kthot.js.dsl.dom.type.core.node

import net.asere.kthot.js.dsl.JsNothing
import net.asere.kthot.js.dsl.dom.type.content.document.JsDocument
import net.asere.kthot.js.dsl.dom.type.content.document.syntax
import net.asere.kthot.js.dsl.dom.type.core.element.JsDomElement
import net.asere.kthot.js.dsl.dom.type.core.element.syntax
import net.asere.kthot.js.dsl.dom.type.core.event.target.JsEventTarget
import net.asere.kthot.js.dsl.dom.type.core.node.list.JsNodeList
import net.asere.kthot.js.dsl.dom.type.core.node.list.syntax
import net.asere.kthot.js.dsl.syntax
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.js
import net.asere.kthot.js.dsl.type.bool.syntax
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.JsStringRef
import net.asere.kthot.js.dsl.type.string.ref
import net.asere.kthot.js.dsl.type.string.syntax

/**
 * Represents the JavaScript `Node` interface. This is the root interface for all document nodes
 * (Element, Text, Comment, Document, etc.) and provides fundamental tree structure manipulation
 * and navigation properties. It extends the base [JsEventTarget] interface.
 */
interface JsNode : JsEventTarget {

    /**
     * Returns a string representing the base URL of the document containing the Node.
     * Corresponds to `node.baseURI`.
     */
    val baseURI: JsString
        get() = JsString.syntax(ChainOperation(this, "baseURI"))

    /**
     * Returns an [JsNodeList] containing all the children of this node (including elements, text, and comments).
     * Corresponds to `node.childNodes`.
     */
    val childNodes: JsNodeList
        get() = JsNodeList.syntax(ChainOperation(this, "childNodes"))

    /**
     * Returns a [JsNode] representing the first direct child node, or null.
     * Corresponds to `node.firstChild`.
     */
    val firstChild: JsNode
        get() = JsNode.syntax(ChainOperation(this, "firstChild"))

    /**
     * A boolean indicating whether or not the Node is connected (directly or indirectly) to the Document.
     * Corresponds to `node.isConnected`.
     */
    val isConnected: JsBoolean
        get() = JsBoolean.syntax(ChainOperation(this, "isConnected"))

    /**
     * Returns a [JsNode] representing the last direct child node, or null.
     * Corresponds to `node.lastChild`.
     */
    val lastChild: JsNode
        get() = JsNode.syntax(ChainOperation(this, "lastChild"))

    /**
     * Returns a [JsNode] representing the next sibling node in the tree, or null.
     * Corresponds to `node.nextSibling`.
     */
    val nextSibling: JsNode
        get() = JsNode.syntax(ChainOperation(this, "nextSibling"))

    /**
     * Returns a string containing the name of the Node (e.g., 'DIV', '#text', '#document').
     * Corresponds to `node.nodeName`.
     */
    val nodeName: JsString
        get() = JsString.syntax(ChainOperation(this, "nodeName"))

    /**
     * Returns an integer representing the type of the node (e.g., 1 for Element, 3 for Text).
     * Corresponds to `node.nodeType`.
     */
    val nodeType: JsNumber
        get() = JsNumber.syntax(ChainOperation(this, "nodeType"))

    /**
     * Returns the [JsDocument] that this node belongs to. If the node is itself a document, returns null.
     * Corresponds to `node.ownerDocument`.
     */
    val ownerDocument: JsDocument
        get() = JsDocument.syntax(ChainOperation(this, "ownerDocument"))

    /**
     * Returns a [JsNode] that is the parent of this node, or null.
     * Corresponds to `node.parentNode`.
     */
    val parentNode: JsNode
        get() = JsNode.syntax(ChainOperation(this, "parentNode"))

    /**
     * Returns an [JsDomElement] that is the parent of this node, or null if the parent is not an element.
     * Corresponds to `node.parentElement`.
     */
    val parentElement: JsDomElement
        get() = JsDomElement.syntax(ChainOperation(this, "parentElement"))

    /**
     * Returns a [JsNode] representing the previous sibling node in the tree, or null.
     * Corresponds to `node.previousSibling`.
     */
    val previousSibling: JsNode
        get() = JsNode.syntax(ChainOperation(this, "previousSibling"))

    /**
     * Gets/Sets the value of the current node (e.g., the content of a Text or Comment node).
     * Corresponds to `node.nodeValue`.
     */
    val nodeValue: JsStringRef
        get() = JsString.ref(ChainOperation(this, "nodeValue"))

    /**
     * Gets/Sets the textual content of an element and all its descendants.
     * Corresponds to `node.textContent`.
     */
    val textContent: JsStringRef
        get() = JsString.ref(ChainOperation(this, "textContent"))

    /**
     * Adds the specified child node as the last child to the current node.
     * Corresponds to `node.appendChild(child)`.
     * @param child The [JsNode] to append.
     * @return The appended [JsNode].
     */
    fun appendChild(child: JsNode): JsNode =
        JsNode.syntax(ChainOperation(this, InvocationOperation("appendChild", child)))

    /**
     * Removes a child node from the current element.
     * Corresponds to `node.removeChild(child)`.
     * @param child The [JsNode] to remove.
     * @return The removed [JsNode].
     */
    fun removeChild(child: JsNode): JsNode =
        JsNode.syntax(ChainOperation(this, InvocationOperation("removeChild", child)))

    /**
     * Inserts a [JsNode] before the reference node as a child of the parent.
     * Corresponds to `node.insertBefore(newNode, referenceNode)`.
     * @param newNode The [JsNode] to insert.
     * @param referenceNode The [JsNode] before which newNode is inserted (or null).
     * @return The inserted [JsNode].
     */
    fun insertBefore(newNode: JsNode, referenceNode: JsNode): JsNode =
        JsNode.syntax(ChainOperation(this, InvocationOperation("insertBefore", newNode, referenceNode)))

    /**
     * Replaces one child [JsNode] with another.
     * Corresponds to `node.replaceChild(newChild, oldChild)`.
     * @param newChild The [JsNode] to replace the existing child.
     * @param oldChild The [JsNode] to be replaced.
     * @return The replaced [JsNode] (oldChild).
     */
    fun replaceChild(newChild: JsNode, oldChild: JsNode): JsNode =
        JsNode.syntax(ChainOperation(this, InvocationOperation("replaceChild", newChild, oldChild)))

    /**
     * Clones the node and optionally all of its contents.
     * Corresponds to `node.cloneNode(deep)`.
     * @param deep A [JsBoolean] indicating whether to perform a deep clone (default is false).
     * @return The cloned [JsNode].
     */
    fun cloneNode(deep: JsBoolean = false.js): JsNode =
        JsNode.syntax(ChainOperation(this, InvocationOperation("cloneNode", deep)))

    /**
     * Returns a boolean value indicating whether or not the element has any child nodes.
     * Corresponds to `node.hasChildNodes()`.
     */
    fun hasChildNodes(): JsBoolean =
        JsBoolean.syntax(ChainOperation(this, InvocationOperation("hasChildNodes")))

    /**
     * Returns the context object's root (e.g., the Document or ShadowRoot).
     * Corresponds to `node.getRootNode(options)`.
     * @return The root [JsNode].
     */
    fun getRootNode(): JsNode =
        JsNode.syntax(ChainOperation(this, InvocationOperation("getRootNode")))

    /**
     * Returns a boolean value indicating whether or not a node is a descendant of the calling node.
     * Corresponds to `node.contains(otherNode)`.
     * @param otherNode The potential descendant [JsNode].
     * @return A [JsBoolean] indicating containment.
     */
    fun contains(otherNode: JsNode): JsBoolean =
        JsBoolean.syntax(ChainOperation(this, InvocationOperation("contains", otherNode)))

    /**
     * Clean up all the text nodes under this element (merge adjacent, remove empty).
     * Corresponds to `node.normalize()`.
     */
    fun normalize(): JsNothing =
        JsNothing.syntax(ChainOperation(this, InvocationOperation("normalize")))

    /**
     * Compares the position of the current node against another node. (Returns a bitmask integer).
     * Corresponds to `node.compareDocumentPosition(otherNode)`.
     */
    fun compareDocumentPosition(otherNode: JsNode): JsNumber =
        JsNumber.syntax(ChainOperation(this, InvocationOperation("compareDocumentPosition", otherNode)))

    /**
     * Returns a boolean value which indicates whether or not two nodes are of the same type and all their defining data points match.
     * Corresponds to `node.isEqualNode(otherNode)`.
     */
    fun isEqualNode(otherNode: JsNode): JsBoolean =
        JsBoolean.syntax(ChainOperation(this, InvocationOperation("isEqualNode", otherNode)))

    /**
     * Returns a boolean value indicating whether or not the two nodes are the same (reference the same object).
     * Corresponds to `node.isSameNode(otherNode)`.
     */
    fun isSameNode(otherNode: JsNode): JsBoolean =
        JsBoolean.syntax(ChainOperation(this, InvocationOperation("isSameNode", otherNode)))

    /**
     * Accepts a prefix and returns the namespace URI associated with it on the given node.
     * Corresponds to `node.lookupNamespaceURI(prefix)`.
     */
    fun lookupNamespaceURI(prefix: JsString): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("lookupNamespaceURI", prefix)))

    /**
     * Returns a string containing the prefix for a given namespace URI.
     * Corresponds to `node.lookupPrefix(namespaceURI)`.
     */
    fun lookupPrefix(namespaceURI: JsString): JsString =
        JsString.syntax(ChainOperation(this, InvocationOperation("lookupPrefix", namespaceURI)))

    /**
     * Returns a boolean value indicating if the namespace is the default namespace on the given node.
     * Corresponds to `node.isDefaultNamespace(namespaceURI)`.
     */
    fun isDefaultNamespace(namespaceURI: JsString): JsBoolean =
        JsBoolean.syntax(ChainOperation(this, InvocationOperation("isDefaultNamespace", namespaceURI)))


    companion object {
        const val ELEMENT_NODE: Int = 1
        const val ATTRIBUTE_NODE: Int = 2
        const val TEXT_NODE: Int = 3
        const val CDATA_SECTION_NODE: Int = 4
        const val ENTITY_REFERENCE_NODE = 5
        const val ENTITY_NODE = 6
        const val PROCESSING_INSTRUCTION_NODE = 7
        const val COMMENT_NODE: Int = 8
        const val DOCUMENT_NODE: Int = 9
        const val DOCUMENT_TYPE_NODE: Int = 10
        const val DOCUMENT_FRAGMENT_NODE: Int = 11
    }
}